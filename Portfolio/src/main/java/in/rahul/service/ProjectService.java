package in.rahul.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rahul.dto.ProjectDetailsDto;
import in.rahul.dto.ProjectUpdateRequestDto;
import in.rahul.exception.NotFoundException;
import in.rahul.model.Project;
import in.rahul.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;
	
	// add project
	
	
	public ProjectDetailsDto addProject(Project project) {
		project.setId(UUID.randomUUID().toString());
		
	project=	repository.save(project);
	
	return new ProjectDetailsDto(project.getName(),project.getDescription(),project.getTechnologies(),project.getGithubUrl(),project.getLiveUrl(),project.getImageUrl());
	
	}
	
	// updateProject
	
	public ProjectDetailsDto  updateProjectDetails(ProjectUpdateRequestDto requestDto) {
		
	Project project=	repository.findByName(requestDto.getProjectName()).orElse(null);
	if(project==null) {
		 throw new NotFoundException("Check your project Name and try again");
	}
	ProjectDetailsDto dto = requestDto.getDetailsDto();
	if(dto.getName().length()>2)project.setName(dto.getName());
	if(dto.getDescription().length()>2) project.setDescription(dto.getDescription());
	if(dto.getImageUrl().length()>2) project.setImageUrl(dto.getImageUrl());
	if(dto.getGithubUrl().length()>2) project.setGithubUrl(dto.getGithubUrl());
	if(dto.getTechnologies().length()>2) project.setTechnologies(dto.getTechnologies());
	if(dto.getLiveUrl().length()>2) project.setLiveUrl(dto.getLiveUrl());
	
	project = repository.save(project);
	return new ProjectDetailsDto(project.getName(),project.getDescription(),project.getTechnologies(),project.getGithubUrl(),project.getLiveUrl(),project.getImageUrl());
	
		
	}
	
	//Delete Project
	public String deleteProjectDetails(String projectName) {
		Project project=	repository.findByName(projectName).orElse(null);
		if(project==null) {
			 throw new NotFoundException("Check your project Name and try again");
		}
		repository.delete(project);
return "Deleted SuccessFully"+project.getId()+" "+projectName;
	}
	
	
}
