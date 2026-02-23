package in.rahul.dto;

public class ProjectDetailsDto {

	private String name;
	private String description;
	private String technologies;
	private String githubUrl;
	private String liveUrl;
	private String imageUrl;
	
	
	public ProjectDetailsDto(String name, String description, String technologies, String githubUrl, String liveUrl,
			String imageUrl) {
		
		this.name = name;
		this.description = description;
		this.technologies = technologies;
		this.githubUrl = githubUrl;
		this.liveUrl = liveUrl;
		this.imageUrl = imageUrl;
	}


	public ProjectDetailsDto() {
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTechnologies() {
		return technologies;
	}


	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}


	public String getGithubUrl() {
		return githubUrl;
	}


	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}


	public String getLiveUrl() {
		return liveUrl;
	}


	public void setLiveUrl(String liveUrl) {
		this.liveUrl = liveUrl;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	
	
}
