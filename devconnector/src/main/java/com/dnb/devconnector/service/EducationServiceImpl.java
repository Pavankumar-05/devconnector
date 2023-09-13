package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.repo.EducationRepository;



@Service
public class EducationServiceImpl implements EducationService {
	
	@Autowired
	EducationRepository educationRepository;

	@Override
	public Education createEducationDetails(Education education) {
		// TODO Auto-generated method stub
		return educationRepository.save(education);
	}

	@Override
	public Optional<Education> getEducationDetailsById(String educationId) {
		// TODO Auto-generated method stub
		return educationRepository.findById(educationId);
	}

	@Override
	public boolean deleteEducationDetailsById(String educationId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		boolean isPresent = educationRepository.existsById(educationId);
		if(isPresent) {
			educationRepository.deleteById(educationId);
			
		}else {
			throw new IdNotFoundException("Id not Found");
		}
		if(educationRepository.existsById(educationId))
			return false;
		else
			return true;
	}

	@Override
	public List<Education> getAllEducationDetails() {
		// TODO Auto-generated method stub
		return (List<Education>) educationRepository.findAll();
	}

}
