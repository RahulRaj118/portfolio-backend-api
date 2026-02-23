package in.rahul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rahul.dto.ProfileDisplayDto;
import in.rahul.dto.ProjectDetailsDto;
import in.rahul.dto.SkillDetailsDto;
import in.rahul.service.GetAllDataService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FetchGetDataController {

	@Autowired
	private GetAllDataService service;
	
	//for profile
	
	@GetMapping("/profile")
	public ResponseEntity< List<ProfileDisplayDto> >getAllProfile(){
	return new ResponseEntity<>(service.getAllProfile(),HttpStatus.OK);
	}
	
	//for fetching Skill
	
	@GetMapping("/skill")
	public ResponseEntity< List<SkillDetailsDto>> getAllSkill(){
		return new ResponseEntity<List<SkillDetailsDto>>(service.getAllSkill(),HttpStatus.OK);
	}
	
	// for fetching project
	
	@GetMapping("/project")
	public ResponseEntity< List<ProjectDetailsDto>> getAllProject(){
		return new ResponseEntity<List<ProjectDetailsDto>>(service.getAllProject(),HttpStatus.OK);
	}
	
	
}
