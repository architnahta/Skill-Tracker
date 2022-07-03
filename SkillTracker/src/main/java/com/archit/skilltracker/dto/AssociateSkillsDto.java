package com.archit.skilltracker.dto;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.archit.skilltracker.model.Associate;
import com.archit.skilltracker.model.Skills;

public class AssociateSkillsDto {
	
	private Integer associateSkillId;
	
	private String associateId;
	
	private Integer skillId;
	
	private Associate associate;
	
	private Skills skills;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 20)
	private Integer skillRate;

	public Integer getSkillRate() {
		return skillRate;
	}

	public void setSkillRate(Integer skillRate) {
		this.skillRate = skillRate;
	}

	public Integer getAssociateSkillId() {
		return associateSkillId;
	}

	public void setAssociateSkillId(Integer associateSkillId) {
		this.associateSkillId = associateSkillId;
	}

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Associate getAssociate() {
		return associate;
	}

	public void setAssociate(Associate associate) {
		this.associate = associate;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	@Override
	public int hashCode() {
		return Objects.hash(associate, associateId, associateSkillId, skillId, skillRate, skills);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssociateSkillsDto other = (AssociateSkillsDto) obj;
		return Objects.equals(associate, other.associate) && Objects.equals(associateId, other.associateId)
				&& Objects.equals(associateSkillId, other.associateSkillId) && Objects.equals(skillId, other.skillId)
				&& Objects.equals(skillRate, other.skillRate) && Objects.equals(skills, other.skills);
	}
	

}
