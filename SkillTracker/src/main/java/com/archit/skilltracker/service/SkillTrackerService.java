package com.archit.skilltracker.service;

import java.util.List;

import com.archit.skilltracker.vo.AssociateVO;
import com.archit.skilltracker.vo.SkillVO;

public interface SkillTrackerService {
	
	List<SkillVO> viewAllSkills();

	List<AssociateVO> viewAllAssociates();
	
	List<AssociateVO> viewAllAssociatesBySkill(String skillName);

}
