package com.wilson.travelCompanion.database;

import java.util.HashMap;
import java.util.Map;


import com.wilson.travelCompanion.model.User;

public class UserDatabase {
	
	private static Map<Long, User> users = new HashMap<>();
	
	public static Map<Long, User> getUsers() {
		return users;
	}

}
