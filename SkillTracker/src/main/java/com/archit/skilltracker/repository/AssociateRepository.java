package com.archit.skilltracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.archit.skilltracker.model.Associate;
import com.archit.skilltracker.model.AssociateSkills;

public interface AssociateRepository extends CrudRepository<Associate, Integer>{

	@Query(value="select associate.associate_id, associate.name,\r\n"
			+ "associate.email, associate.mobile\r\n"
			+ "from associate \r\n"
			+ "inner join associate_skills On \r\n"
			+ "associate.associate_id=associate_skills.associate_id \r\n"
			+ "where associate_skills.skill_id = \r\n"
			+ "(select skill_id from skills where skill_name=:skillName) and associate_skills.skill_rate>=10 order by associate_skills.skill_rate desc", nativeQuery = true)
	List<Associate> findByAssociateSkill(@Param("skillName") String skillName);
	
}
