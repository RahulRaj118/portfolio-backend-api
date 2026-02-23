package in.rahul.dto;

public class SkillDetailsDto {

	private String name;
	private String category;
	private String proficiency;
	private int displayOrder;
	public SkillDetailsDto() {
	
	}
	public SkillDetailsDto(String name, String category, String proficiency, int displayOrder) {
		
		this.name = name;
		this.category = category;
		this.proficiency = proficiency;
		this.displayOrder = displayOrder;
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
