package com.prac.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDB {

	public static List<User> users = new ArrayList<>();
	
	static{
		users.add(new User(1,"UserA",new Date()));
		users.add(new User(2,"UserB",new Date()));
		users.add(new User(3,"UserC",new Date()));
		users.add(new User(4,"UserD",new Date()));
	}

	public List<User> getUsers() {
		return users;
	}

	public void saveUser(User user) {
		users.add(user);
	}
}
