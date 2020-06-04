package com.fabio.Assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fabio.Assignment14.domain.User;

@Repository
public class UserRepository {

	private List<User> userList = new ArrayList<>();
	
	public List<User> saveUsers(User user) {
		userList.add(user);
		
		return userList;
	}

	public List<User> getUsers() {
		
		return userList;
	}

	public User getUserByUsername(String userName) {
		List<User> user = userList.stream()
		.collect(Collectors.filtering(o -> o.getUserName().equals(userName), Collectors.toList()));
		User activeUser = user.get(0);
		
		return activeUser;
	}
	
}
