package in.rahul.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rahul.dto.ProfileRegisterDto;
import in.rahul.dto.ProfileUpdateDto;
import in.rahul.dto.ProfileUpdateRequest;
import in.rahul.exception.NotFoundException;
import in.rahul.model.Profile;
import in.rahul.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository repo;
	
	
	
	//Adding  profile
	public ProfileRegisterDto regiserProfile(Profile profile) {
		profile.setId(UUID.randomUUID().toString());
		
		Profile profile2=repo.save(profile);
		
	return new ProfileRegisterDto(profile2.getName(), profile2.getTitle(), profile2.getBio(), profile2.getEmail(), profile2.getLinkedinUrl(), profile2.getGithubUrl());
	}
	
	
	//Update Profile
	public Profile updateProfile(ProfileUpdateRequest request) {
		Profile profile = repo.findByEmailAndName(request.getEmail(), request.getName()).orElse(null);
		if(profile==null) {
			throw new NotFoundException("Check your mail and name carefully because no data found");
		}
		
	ProfileUpdateDto updateDto = request.getProfileUpdateDto();
	if(updateDto.getName()!=null) {
		profile.setName(updateDto.getName());
	}
	if(updateDto.getEmail()!=null) {
		profile.setEmail(updateDto.getEmail());
	}
	if(updateDto.getTitle()!=null) {
		profile.setTitle(updateDto.getTitle());
	}
	if(updateDto.getBio()!=null) {
		profile.setBio(updateDto.getBio());
	}
	if(updateDto.getGithubUrl()!=null) {
		profile.setGithubUrl(updateDto.getGithubUrl());
		
	}
	if(updateDto.getLinkedInUrl()!=null) {
		profile.setLinkedinUrl(updateDto.getLinkedInUrl());
	}
	
	
	return repo.save(profile);
	}
	
	// delete 
	
	public String deleteProfile(String email,String name) {
		
		Profile profile = repo.findByEmailAndName(email, name).orElse(null);
		if(profile==null) {
			throw new NotFoundException("Check your email or name! No record found ");
		}
		
		repo.delete(profile);
		return "Deleted SuccessFully";
	}
	

}
