package in.rahul.dto;

public class ProjectUpdateRequestDto {
private String projectName;
private ProjectDetailsDto detailsDto;


public ProjectUpdateRequestDto() {
	
}
public ProjectUpdateRequestDto(String projectName, ProjectDetailsDto detailsDto) {
	this.projectName = projectName;
	this.detailsDto = detailsDto;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public ProjectDetailsDto getDetailsDto() {
	return detailsDto;
}
public void setDetailsDto(ProjectDetailsDto detailsDto) {
	this.detailsDto = detailsDto;
}


}
