package in.rahul.dto;

public class SkillUpdateRequestDto {

	private String name;
	private String category;
	
	private SkillDetailsDto skillDetailsDto;

	
	
	
	public SkillUpdateRequestDto() {
		
	}

	public SkillUpdateRequestDto(String name, String category, SkillDetailsDto skillDetailsDto) {
	
		this.name = name;
		this.category = category;
		this.skillDetailsDto = skillDetailsDto;
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

	public SkillDetailsDto getSkillDetailsDto() {
		return skillDetailsDto;
	}

	public void setSkillDetailsDto(SkillDetailsDto skillDetailsDto) {
		this.skillDetailsDto = skillDetailsDto;
	}
	
	
	
}
