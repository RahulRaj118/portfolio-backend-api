package in.rahul.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rahul.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, String>{

	Optional<Skill> findByNameAndCategory(String name,String category);
	
}
