package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.exceptions.IdNotFoundException;

public interface EducationService {
	public Education createEducationDetails(Education education);

	public Optional<Education> getEducationDetailsById(String educationId);

	public boolean deleteEducationDetailsById(String educationId) throws IdNotFoundException;

	public List<Education> getAllEducationDetails();
}
