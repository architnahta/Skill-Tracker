package com.archit.skilltracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.archit.skilltracker.model.AssociateSkills;

public interface AssociateSkillsRepository extends CrudRepository<AssociateSkills, Integer>{
	
	List<AssociateSkills> findByAssociateId(String string);

}
