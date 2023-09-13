package com.dnb.devconnector.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.exceptions.ProfileIdNotFoundException;
import com.dnb.devconnector.repo.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	public static UUID generateAlphanumericUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid;
	}
	
	@Override
	public Profile createUserProfile(Profile profile) {
		profile.setProfileId(this.generateAlphanumericUUID());
		return profileRepository.save(profile);
	}

	@Override
	public Optional<Profile> getUserProfileByProfileId(String profileId) {
		return profileRepository.findById(profileId);
	}

	@Override
	public boolean deleteUserProfileByprofileId(String profileId) throws ProfileIdNotFoundException {
		boolean isPresent = profileRepository.existsById(profileId);
		if(isPresent) {
			profileRepository.deleteById(profileId);
			
		}else {
			throw new ProfileIdNotFoundException("Profile Id not Found");
		}
		if(profileRepository.existsById(profileId))
			return false;
		else
			return true;
	}

	@Override
	public Iterable<Profile> getAllUserProfile() {
		return null;
	}

}
