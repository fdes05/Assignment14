package com.fabio.Assignment14.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.Assignment14.domain.User;
import com.fabio.Assignment14.repository.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userRepo;
	
	public void saveUser(String userName){
		User newUser = new User();
		List<User> existingUsers = userRepo.getUsers();
		Long userId = existingUsers.size() + 1L;
		newUser.setUserId(userId);
		newUser.setUserName(userName);
		List<User> updatedList = userRepo.saveUsers(newUser);
	}
	
	public User getUserbyUsername(String userName) {
		User activeUser = userRepo.getUserByUsername(userName);
		return activeUser;
	}

	public Boolean verifyUserDoesNotExist(String userName) {
		List<User> users = userRepo.getUsers();
		List<String> userNames = users.stream().map(u -> u.getUserName()).collect(Collectors.toList());
		Boolean resultUserExists = userNames.contains(userName);
		return resultUserExists;
	}
}
