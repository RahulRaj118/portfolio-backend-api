package in.rahul.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginCredentialsDto {

	
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
	
	@NotNull(message = "Password cannot be null")
	private String password;

	
	
	
	public LoginCredentialsDto() {
	
	}




	public LoginCredentialsDto(@NotNull(message = "Email cannot be null") @Email String email,
			@NotNull(message = "Password cannot be null") String password) {
		
		this.email = email;
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
