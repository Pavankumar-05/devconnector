package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.EmailNotFoundException;
import com.dnb.devconnector.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	@Override
	public Optional<User> getUserById(String emailId) {
		// TODO Auto-generated method stub
		return userRepository.findById(emailId);
	}

	@Override
	public boolean deleteUserById(String emailId) throws EmailNotFoundException {
		// TODO Auto-generated method stub
		boolean isPresent = userRepository.existsById(emailId);
		if(isPresent) {
			userRepository.deleteById(emailId);
			
		}else {
			throw new EmailNotFoundException("Email not Found");
		}
		if(userRepository.existsById(emailId))
			return false;
		else
			return true;
		 
	}

	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
}
