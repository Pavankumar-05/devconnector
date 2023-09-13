package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.EmailNotFoundException;



public interface UserService {
	public User createUser(User user);

	public Optional<User> getUserById(String userId);

	public boolean deleteUserById(String userId) throws EmailNotFoundException;

	public Iterable<User> getAllUsers();
}
