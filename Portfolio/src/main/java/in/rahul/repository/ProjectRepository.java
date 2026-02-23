package in.rahul.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rahul.model.Project;
import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, String> {

	
	Optional<Project> findByName(String name);
}
