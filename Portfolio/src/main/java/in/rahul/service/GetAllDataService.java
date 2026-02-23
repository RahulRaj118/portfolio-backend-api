package in.rahul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.rahul.dto.ProfileDisplayDto;
import in.rahul.dto.ProjectDetailsDto;
import in.rahul.dto.SkillDetailsDto;
import in.rahul.model.Profile;
import in.rahul.model.Project;
import in.rahul.model.Skill;
import in.rahul.repository.ProfileRepository;
import in.rahul.repository.ProjectRepository;
import in.rahul.repository.SkillRepository;

@Service
public class GetAllDataService {

	
	private ProfileRepository profileRepository;
	
	
	private ProjectRepository projectRepository;
	
	private SkillRepository skillRepository;
	
	
	
	public GetAllDataService(ProfileRepository profileRepository, ProjectRepository projectRepository,
			SkillRepository skillRepository) {
		
		this.profileRepository = profileRepository;
		this.projectRepository = projectRepository;
		this.skillRepository = skillRepository;
	}



	//get profile
	
	public List<ProfileDisplayDto> getAllProfile(){
		List<Profile> list = profileRepository.findAll();
	List<ProfileDisplayDto> profileList = new ArrayList<>();
	
	for(Profile p:list) {
		ProfileDisplayDto dto = new ProfileDisplayDto(p.getName(), p.getEmail(), p.getBio(), p.getTitle(), p.getGithubUrl(), p.getLinkedinUrl());
		profileList.add(dto);
	}
	return profileList;
		
	}
	
	//get All Skill
	
	public List<SkillDetailsDto> getAllSkill(){
		List<Skill> list = skillRepository.findAll();
		
		List<SkillDetailsDto> skillList = new ArrayList<>();
		for(Skill s:list) {
			SkillDetailsDto dto = new SkillDetailsDto(s.getName(), s.getCategory(), s.getProficiency(), s.getDisplayOrder());
			skillList.add(dto);
		}
		return skillList;
	}
	// get All Project
	
	public List<ProjectDetailsDto> getAllProject(){
		List<Project> list  = projectRepository.findAll();
		List<ProjectDetailsDto> projectList = new ArrayList<>();
		for(Project s:list) {
			ProjectDetailsDto detailsDto= new ProjectDetailsDto(s.getName(), s.getDescription(), s.getTechnologies(), s.getGithubUrl(), s.getLiveUrl(),s.getImageUrl());
			projectList.add(detailsDto);
		
		}
		return projectList;
	}
	
}
