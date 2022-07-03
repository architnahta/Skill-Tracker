package com.archit.skilltracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.archit.skilltracker.service.SkillTrackerService;
import com.archit.skilltracker.vo.AssociateVO;
import com.archit.skilltracker.vo.SkillVO;


@RestController
@CrossOrigin

@RequestMapping(value = "/skilltracker")
public class SkillTrackerController {
	
	@Autowired
	private SkillTrackerService skillTrackerService;

	@RequestMapping(value = "/viewallskills", method = RequestMethod.GET)
	public List<SkillVO> viewAllSkills() {
		return skillTrackerService.viewAllSkills();
	}

	@RequestMapping(value = "/getAssociates", method = RequestMethod.GET)
	public List<AssociateVO> viewAllAssociates() {
		return skillTrackerService.viewAllAssociates();
	}
	
	@RequestMapping(value = "/getAssociates/{skillName}", method = RequestMethod.GET)
	public List<AssociateVO> viewAllAssociatesBySkill(@PathVariable String skillName) {
		return skillTrackerService.viewAllAssociatesBySkill(skillName);
	}
}
