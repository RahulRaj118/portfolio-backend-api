package in.rahul.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.rahul.model.User;

public interface UserRepository  extends JpaRepository<User, String>{
 
	@Query("select count(u) from User u")
	long getCount();
	
	Optional<User>  findByUsername(String username);
	
}
