package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.repo.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService {
	
	@Autowired
	ExperienceRepository experienceRepository;
	
	@Override
	public Experience createExperienceDetails(Experience experience) {
		// TODO Auto-generated method stub
		return experienceRepository.save(experience);
	}

	@Override
	public Optional<Experience> getExperienceDetailsById(String experienceId) {
		// TODO Auto-generated method stub
		return experienceRepository.findById(experienceId);
	}

	@Override
	public boolean deleteExperienceDetailsById(String experienceId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		boolean isPresent = experienceRepository.existsById(experienceId);
		if(isPresent) {
			experienceRepository.deleteById(experienceId);
			
		}else {
			throw new IdNotFoundException("Id not Found");
		}
		if(experienceRepository.existsById(experienceId))
			return false;
		else
			return true;
	}

	@Override
	public List<Experience> getAllExperienceDetails() {
		// TODO Auto-generated method stub
		return (List<Experience>) experienceRepository.findAll();
	}

}
