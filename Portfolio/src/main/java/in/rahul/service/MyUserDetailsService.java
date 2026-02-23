package in.rahul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.rahul.exception.NotFoundException;
import in.rahul.model.User;
import in.rahul.repository.UserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userRepository.findByUsername(email).orElse(null);
		if(user==null) {
			throw new NotFoundException("Email or password invalid");
		}
		return org.springframework.security.core.userdetails.User.withUsername(email)
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
	}

}
