package in.rahul.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rahul.dto.SkillDetailsDto;
import in.rahul.dto.SkillUpdateRequestDto;
import in.rahul.exception.NotFoundException;
import in.rahul.model.Skill;
import in.rahul.repository.SkillRepository;


@Service
public class SkillService {

	
	@Autowired
	private SkillRepository repository;
	
	
	//add Skill
	public SkillDetailsDto addSkill(Skill skill) {
		
		skill.setId(UUID.randomUUID().toString());
		repository.save(skill);
		return new SkillDetailsDto(skill.getName(),skill.getCategory(),skill.getProficiency(),skill.getDisplayOrder());
	}
	
	//updateSkill
	public SkillDetailsDto updateSkill(SkillUpdateRequestDto requestDto) {
	
		Skill skill = repository.findByNameAndCategory(requestDto.getName(), requestDto.getCategory()).orElse(null);
		if(skill==null) {
			throw new NotFoundException("Check your skill name and category! And try again later");
		}
		SkillDetailsDto skillDetailsDto = requestDto.getSkillDetailsDto();
		
		if(skillDetailsDto.getName()!=null) skill.setName(skillDetailsDto.getName());
		if(skillDetailsDto.getCategory()!=null) skill.setCategory(skillDetailsDto.getCategory());
		if(skillDetailsDto.getProficiency()!=null)skill.setProficiency(skillDetailsDto.getProficiency());
		if(skillDetailsDto.getDisplayOrder()!=0) skill.setDisplayOrder(skillDetailsDto.getDisplayOrder()); 
		
	Skill skill2=	repository.save(skill);
		return new SkillDetailsDto(skill2.getName(), skill2.getCategory(),skill2.getProficiency() ,skill2.getDisplayOrder());
	}
	
	//deleteSkill
	public String deleteSkill(String name,String category) {
		Skill skill = repository.findByNameAndCategory(name, category).orElse(null);
		if(skill==null) throw new NotFoundException("Check your name and category for delete the skill! so try again");
		repository.delete(skill);
		return "Deleted Successfully";
		
	}
	
}
