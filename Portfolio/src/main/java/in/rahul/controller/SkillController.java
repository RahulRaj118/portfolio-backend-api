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

import in.rahul.dto.SkillDetailsDto;
import in.rahul.dto.SkillUpdateRequestDto;
import in.rahul.model.Skill;
import in.rahul.service.SkillService;

@RestController
@RequestMapping("/admin/api")
public class SkillController {

	@Autowired
	private SkillService service;
	
	
	//add Skill
	@PostMapping("/addSkill")
	public ResponseEntity< SkillDetailsDto> addSkill(@RequestBody  Skill skill) {
		return new ResponseEntity<SkillDetailsDto>(service.addSkill(skill),HttpStatus.CREATED);
	}
	
	// update Skill
	
	@PutMapping("/updateSkill")
	public ResponseEntity< SkillDetailsDto> updateSkill(@RequestBody SkillUpdateRequestDto requestDto) {
		return new ResponseEntity<>(service.updateSkill(requestDto),HttpStatus.OK);
	}
	
	// delete Skill
	
	@DeleteMapping("/deleteSkill/{name}/{category}")
	public ResponseEntity< String> deleteSkill(String name,String category) {
		return new ResponseEntity<String>(service.deleteSkill(name, category),HttpStatus.OK);
	}
	
}
