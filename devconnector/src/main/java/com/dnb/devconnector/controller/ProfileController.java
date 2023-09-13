package com.dnb.devconnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	@Autowired
	ProfileService profileService;
	@RequestMapping("/create")
	public Profile createUserProfile(Profile profile) {
		return profileService.createUserProfile(profile);
	}
}
