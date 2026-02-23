 package in.rahul.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rahul.model.Profile;
import java.util.List;


public interface ProfileRepository extends JpaRepository<Profile, String>{

	
	Optional<Profile>  findByEmailAndName(String email, String name);
}
