package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.userrepositories.UserReposittory;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserReposittory userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserDetails(long id) {
		return userRepository.findById(id);
	}

	@Override
	public User updateUserDetails(long id, User newUser) {
		User userData = userRepository.findById(id).orElse(null);
		if (userData != null) {
			return userRepository.save(newUser);
		}
		else
		{
			throw new RuntimeException("user not found");
		}

	}

	@Override
	public void deleteUser(long id) {
	  userRepository.deleteById(id);
		
	}

}
