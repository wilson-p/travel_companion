package com.wilson.travelCompanion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wilson.travelCompanion.database.UserDatabase;
import com.wilson.travelCompanion.model.User;

public class UserService {
	
	private Map<Long, User> userList = UserDatabase.getUsers();
	
	public UserService() {
	
		userList.put(1L, new User(1, "Wilson Paul", "wpaul@gmail.com", "awesome"));
		userList.put(2L, new User(2, "Ryan Fung", "Ryan@gmail.com", "awesome"));
		userList.put(3L, new User(3, "John", "john@gmail.com", "awesome"));
		
	}
	
	public List<User> getAllUsers() {
		return new ArrayList<User>(userList.values());
	}
	
	public User getUser(long userId) {
		if (userId > 0) {
			User user = userList.get(userId);
			return user;
		}	
		return new User();
	}

	public User addUser(User user) {
		user.setUserId(userList.size()+1);
		userList.put(user.getUserId(), user);
		return user;
	}

	public User updateUser(User user) {	
		userList.put(user.getUserId(), user);
		return user;
	}

	public User removeUser(long userId) {
		return userList.remove(userId);
	}
	
}
