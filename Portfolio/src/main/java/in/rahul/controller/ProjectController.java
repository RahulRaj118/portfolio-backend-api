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

import in.rahul.dto.ProjectDetailsDto;
import in.rahul.dto.ProjectUpdateRequestDto;
import in.rahul.model.Project;
import in.rahul.service.ProjectService;

@RestController
@RequestMapping("/admin/api")
public class ProjectController {
	
	
	@Autowired
	private ProjectService service;
	
	// for adding project
	
	@PostMapping("/addProject")
	public ResponseEntity< ProjectDetailsDto> addProject(@RequestBody Project project) {
		return new ResponseEntity<ProjectDetailsDto>(service.addProject(project),HttpStatus.CREATED);
	}
	
	// for update
	@PutMapping("/updateProject")
	public ResponseEntity< ProjectDetailsDto>  updateProjectDetails(@RequestBody ProjectUpdateRequestDto requestDto) {
	
		return new ResponseEntity<ProjectDetailsDto>(service.updateProjectDetails(requestDto),HttpStatus.OK);
	}
	
	// for delete 
	
	@DeleteMapping("/deleteProject/{projectName}")
	public ResponseEntity< String> deleteProjectDetails(@PathVariable String projectName) {
		return new ResponseEntity<String>(service.deleteProjectDetails(projectName),HttpStatus.OK);
	}
	
	
}
