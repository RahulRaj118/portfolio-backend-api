package in.rahul.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_messages")
public class ContactMessage {

	@Id
	private String id;
	
	private String senderEmail;
	
	@Column(length = 2000)
	private String message;
	
	 private LocalDateTime createdAt;
	
	private Boolean isRead;

	
	
	
	
	public ContactMessage() {
		
	}





	public ContactMessage(String id, String senderEmail, String message, LocalDateTime createdAt, Boolean read) {
		
		this.id = id;
		this.senderEmail = senderEmail;
		this.message = message;
		this.createdAt = createdAt;
		this.isRead = read;
	}





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getSenderEmail() {
		return senderEmail;
	}





	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public LocalDateTime getCreatedAt() {
		return createdAt;
	}





	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}





	public Boolean getIsRead() {
		return isRead;
	}





	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}





	
	
	
	
	
	
	
	
}
