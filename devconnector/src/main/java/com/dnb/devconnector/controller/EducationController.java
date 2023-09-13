package com.dnb.devconnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.service.EducationService;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	@Autowired
	EducationService educationService;
	@RequestMapping("/create")
	public Education createEduactionDetails(Education education) {
		return educationService.createEducationDetails(education);
	}
}
