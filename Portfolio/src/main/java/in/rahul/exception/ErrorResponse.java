package in.rahul.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	
	private String message;
	private int statuscode;
	
	private LocalDateTime time;
	
	
	public ErrorResponse() {
	}


	public ErrorResponse(String message, int statuscode, LocalDateTime time) {
		
		this.message = message;
		this.statuscode = statuscode;
		this.time = time;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getStatuscode() {
		return statuscode;
	}


	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}


	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	
	
}
