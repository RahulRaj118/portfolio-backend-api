package in.rahul.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.rahul.dto.LoginCredentialsDto;
import in.rahul.dto.RegisterUserDto;
import in.rahul.exception.UserCreatedException;
import in.rahul.model.User;
import in.rahul.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService service;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	
	//registerUser
	public RegisterUserDto register(User user) {
		if(userRepository.count()>0) throw new UserCreatedException(" user already  created");
		
		user.setId(UUID.randomUUID().toString());
		user.setPassword(encoder.encode(user.getPassword()));
		
		user = userRepository.save(user);
		return new RegisterUserDto(user.getUsername(),user.getPassword(),user.getRole());
		
	}

	//login 
	public String loginUser(LoginCredentialsDto credential) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getEmail(), credential.getPassword()));
		if(authentication.isAuthenticated()) {
			String email = authentication.getName();
			User user = userRepository.findByUsername(email).orElse(null);
			String token= service.generateToken(email, user);
			return token;
		}
		return "Failed";
	}
	

}
