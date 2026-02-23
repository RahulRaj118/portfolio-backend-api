package in.rahul.model;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
	
	@Id
	private String id;
	
	private String name;
	
	private String title;
	@Column(length = 10000)
	private String bio;
	private String email;
	private String linkedinUrl;
	private String githubUrl;
	
	
	public Profile() {
	
	}


	public Profile(String name, String title, String bio, String email, String linkedinUrl, String githubUrl) {
	
		this.name = name;
		this.title = title;
		this.bio = bio;
		this.email = email;
		this.linkedinUrl = linkedinUrl;
		this.githubUrl = githubUrl;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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
