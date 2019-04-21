package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDB {

	public static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "UserA", new Date()));
		users.add(new User(2, "UserB", new Date()));
		users.add(new User(3, "UserC", new Date()));
		users.add(new User(4, "UserD", new Date()));
	}

	public List<User> getUsers() {
		return users;
	}

	public User saveUser(User user) {
		users.add(user);
		return user;
	}

	public User deleteUser(int id) {
		Optional<User> user = users.stream()
							 .filter(u -> (u.getId() == id))
							 .findFirst();
		if (user.isPresent()) {
			users.remove(user.get());
			return user.get();
		}
		return null;
	}
}
