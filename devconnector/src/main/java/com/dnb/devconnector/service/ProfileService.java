package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.exceptions.ProfileIdNotFoundException;

public interface ProfileService {
	public Profile createUserProfile(Profile profile);

	public Optional<Profile> getUserProfileByProfileId(String profileId);

	public boolean deleteUserProfileByprofileId(String profileId) throws ProfileIdNotFoundException;

	public Iterable<Profile> getAllUserProfile();
}
