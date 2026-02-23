package in.rahul.dto;

import jakarta.persistence.Column;

public class ProfileRegisterDto {

private String name;
	
	private String title;
	
	private String bio;
	private String email;
	private String linkedinUrl;
	private String githubUrl;
	public ProfileRegisterDto(String name, String title, String bio, String email, String linkedinUrl,
			String githubUrl) {
	
		this.name = name;
		this.title = title;
		this.bio = bio;
		this.email = email;
		this.linkedinUrl = linkedinUrl;
		this.githubUrl = githubUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLinkedinUrl() {
		return linkedinUrl;
	}
	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}
	public String getGithubUrl() {
		return githubUrl;
	}
	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}
	
	
}
