package com.archit.skilltracker.vo;

import java.util.ArrayList;
import java.util.List;

public class AssociateVO {
	
	private String associateId;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private List<SkillVO> skills;
	
	public void setSkills(List<SkillVO> skills) {
		this.skills = skills;
	}
	
	public List<SkillVO> getSkills() {
		if (skills == null) {
			skills = new ArrayList<SkillVO>();
		}
		return skills;
	}
	
	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "AssociateVO [associateId=" + associateId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", skills=" + skills + "]";
	}

	
	

}
