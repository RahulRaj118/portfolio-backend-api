package in.rahul.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {

	@Id
	private String id;
	
	private String name;
	private String category;
	private String proficiency;
	private int displayOrder;
	
	
	
	
	
	public Skill() {
		
	}





	public Skill( String name, String category, String proficiency, int displayOrder) {
		
		this.name = name;
		this.category = category;
		this.proficiency = proficiency;
		this.displayOrder = displayOrder;
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





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public String getProficiency() {
		return proficiency;
	}





	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}





	public int getDisplayOrder() {
		return displayOrder;
	}





	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	
	
	
	
	
	
}
