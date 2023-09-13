package com.dnb.devconnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.service.ExperienceService;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
	@Autowired
	ExperienceService experienceService;
	@RequestMapping("/create")
	public Experience createExperienceDetails(Experience experience) {
		return experienceService.createExperienceDetails(experience);
	}
}
