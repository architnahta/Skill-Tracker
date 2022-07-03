package com.archit.skilltracker.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.archit.skilltracker.model.Associate;
import com.archit.skilltracker.model.AssociateSkills;
import com.archit.skilltracker.model.Skills;
import com.archit.skilltracker.repository.AssociateRepository;
import com.archit.skilltracker.repository.AssociateSkillsRepository;
import com.archit.skilltracker.repository.SkillsRepository;
import com.archit.skilltracker.service.SkillTrackerService;
import com.archit.skilltracker.vo.AssociateVO;
import com.archit.skilltracker.vo.SkillVO;

@Service("skillTrackerService")
public class SkillTrackerServiceImpl implements SkillTrackerService{
	
	@Autowired
	private AssociateRepository associateRepository;
	
	@Autowired
	private AssociateSkillsRepository associateSkillsRepository;
	
	@Autowired
	private SkillsRepository skillsRepository;
	
	@Override
	@Cacheable("skills")
	public List<SkillVO> viewAllSkills() {
		List<SkillVO> skillsList = new ArrayList<SkillVO>();
		List<Skills> skills = (List<Skills>) skillsRepository.findAll();
		if(skills != null && !skills.isEmpty()) {
			SkillVO skillVO;
			for (Skills skill: skills) {
				skillVO = new SkillVO();
				skillVO.setSkillId(skill.getSkillId());
				skillVO.setSkillName(skill.getSkillName());
				skillsList.add(skillVO);
			}
		}
		return skillsList;
	}

	@Override
	@Cacheable("associates")
	public List<AssociateVO> viewAllAssociates() {
		List<AssociateVO> associateVOList = new ArrayList<AssociateVO>();
		List<Associate> associateList = (List<Associate>) associateRepository.findAll();
		if(associateList != null && !associateList.isEmpty()) {
			for (Associate associate: associateList) {
				List<AssociateSkills> associateSkillList = (List<AssociateSkills>) 
						associateSkillsRepository.findByAssociateId(associate.getAssociateId());
				associateVOList.add(mapSkillsToAssociate(associate, associateSkillList));
			}
		}
		return associateVOList;
	}
	
	@Override
	@Cacheable("associates")
	public List<AssociateVO> viewAllAssociatesBySkill(String skillName) {
		List<AssociateVO> associateVOList = new ArrayList<AssociateVO>();
		List<Associate> associateList = (List<Associate>) associateRepository.findByAssociateSkill(skillName);
		if(associateList != null && !associateList.isEmpty()) {
			for (Associate associate: associateList) {
				List<AssociateSkills> associateSkillList = (List<AssociateSkills>) 
						associateSkillsRepository.findByAssociateId(associate.getAssociateId());
				associateVOList.add(mapSkillsToAssociate(associate, associateSkillList));
			}
		}
		return associateVOList;
	}
	
	private AssociateVO mapSkillsToAssociate(Associate associate, List<AssociateSkills> associateSkillList) {
		AssociateVO associateVO = new AssociateVO();
		associateVO.setAssociateId(associate.getAssociateId());
		associateVO.setEmail(associate.getEmail());
		associateVO.setMobile(associate.getMobile());
		associateVO.setName(associate.getName());
		if (associateSkillList != null && !associateSkillList.isEmpty()) {
			SkillVO skill;
			for (AssociateSkills associateSkills: associateSkillList) {
				skill = new SkillVO();
				skill.setSkillId(associateSkills.getSkills().getSkillId());
				skill.setSkillName(associateSkills.getSkills().getSkillName());
				skill.setSkillRate(associateSkills.getSkillRate());
				associateVO.getSkills().add(skill);
			}
		}
		return associateVO;
	}

	private void mapAssociateSkills(Associate associate, AssociateVO associateVO) {
		List<AssociateSkills> associateSkillsList = new ArrayList<AssociateSkills>();
		AssociateSkills associateSkills;
		List<AssociateSkills> associateSkillEntityList = (List<AssociateSkills>) associateSkillsRepository
				.findByAssociateId(associate.getAssociateId());
		if (associateSkillEntityList != null && !associateSkillEntityList.isEmpty()) {
			associateSkillsRepository.deleteAll(associateSkillEntityList);
		}
		for (SkillVO skill : associateVO.getSkills()) {
			associateSkills = new AssociateSkills();
			if (associateSkillEntityList != null && !associateSkillEntityList.isEmpty()) {
				for (AssociateSkills associates: associateSkillEntityList) {
					if (associates.getSkills().getSkillId() == skill.getSkillId()) {
						associateSkills = associates;
						break;
					}
				}
			}
			associateSkills.setAssociate(associate);
			if (skill.getSkillRate() > 0) {
				Optional<Skills> skills = skillsRepository.findById(skill.getSkillId());
				if (skills.isPresent()) {
					associateSkills.setSkills(skills.get());
					associateSkills.setSkillRate(skill.getSkillRate());
					associateSkillsList.add(associateSkills);
				}
			}
		}
		associateSkillsRepository.saveAll(associateSkillsList);
	}

}
