package in.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rahul.dto.LoginCredentialsDto;
import in.rahul.dto.RegisterUserDto;
import in.rahul.model.User;
import in.rahul.service.UserService;

@RestController
@RequestMapping("/admin/api")
public class RegisterLoginController {

	
	@Autowired
	private UserService service;
	
	//Register Method
	
	@PostMapping("/register")
	public ResponseEntity<RegisterUserDto> registerUser(@RequestBody User user){
		
	RegisterUserDto dto = 	service.register(user);
	
	return  new ResponseEntity<RegisterUserDto>(dto,HttpStatus.CREATED);
		
	}
	
	//login Method
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginCredentialsDto credentialsDto){
		
		return new ResponseEntity<String>(service.loginUser(credentialsDto),HttpStatus.OK);
	}
	
	
	
	
}
