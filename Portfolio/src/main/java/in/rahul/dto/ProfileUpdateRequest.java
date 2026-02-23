package in.rahul.dto;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProfileUpdateRequest {

	@NotBlank(message = "Email cannot be empty")
	@Email
	private String email;
	@NotBlank(message = "Name cannot be empty")
	@Min(value = 2)
	private String name;
	
	private ProfileUpdateDto profileUpdateDto;

	public ProfileUpdateRequest() {
		
	}

	public ProfileUpdateRequest(String email, String name, ProfileUpdateDto profileUpdateDto) {
	
		this.email = email;
		this.name = name;
		this.profileUpdateDto = profileUpdateDto;
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProfileUpdateDto getProfileUpdateDto() {
		return profileUpdateDto;
	}

	public void setProfileUpdateDto(ProfileUpdateDto profileUpdateDto) {
		this.profileUpdateDto = profileUpdateDto;
	}
	
	
}
