package in.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rahul.dto.ProfileRegisterDto;
import in.rahul.dto.ProfileUpdateRequest;
import in.rahul.model.Profile;
import in.rahul.service.ProfileService;

@RestController
@RequestMapping("/admin/api")
public class ProfileDataController {
	
	@Autowired
	private ProfileService service;

	//add Profile
	
@PostMapping("/addProfile")	
	public ResponseEntity<ProfileRegisterDto> addProfile(@RequestBody Profile profile){
	
	return new ResponseEntity<ProfileRegisterDto> (service.regiserProfile(profile),HttpStatus.CREATED);
	
}

// updateProfile

@PutMapping("/updateProfile")
public ResponseEntity<Profile> updateProfile(@RequestBody  ProfileUpdateRequest request) {
	return new ResponseEntity<Profile>(service.updateProfile(request),HttpStatus.OK);
}

// deleteProfile

@DeleteMapping("/delete/{email}/{name}")
public ResponseEntity<String> deleteProfile(@PathVariable String email, @PathVariable  String name) {

	return new ResponseEntity<String>(service.deleteProfile(email, name),HttpStatus.OK);
}


	
}
