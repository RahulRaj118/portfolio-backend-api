package in.rahul.dto;

public class ProfileDisplayDto {


	private String name;
	private String email;
	private String bio;
	private String title;
	
	private String githubUrl;
	
	private String linkedInUrl;
	
	
	public ProfileDisplayDto() {
		
	}




	public ProfileDisplayDto(String name, String email, String bio, String title, String githubUrl, String linkedInUrl) {
	
		this.name = name;
		this.email = email;
		this.bio = bio;
		this.title = title;
		this.githubUrl=githubUrl;
		this.linkedInUrl=linkedInUrl;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getBio() {
		return bio;
	}




	public void setBio(String bio) {
		this.bio = bio;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getGithubUrl() {
		return githubUrl;
	}




	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}




	public String getLinkedInUrl() {
		return linkedInUrl;
	}




	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	
	
	
	
	
}
