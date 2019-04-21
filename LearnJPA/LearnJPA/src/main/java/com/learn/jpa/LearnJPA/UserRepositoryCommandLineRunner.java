package com.learn.jpa.LearnJPA;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.jpa.LearnJPA.entity.User;
import com.learn.jpa.LearnJPA.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	public static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	@Autowired
	UserRepository userRepositorty;

	@Override
	public void run(String... args) throws Exception {

		// Save using JPA Repository
		User user = new User("Harry", "Architect");
		userRepositorty.save(user);
		log.info("Second User is " + user);

		// Retrieve using JPA Repository
		Optional<User> retrievedUser = userRepositorty.findById(1L);
		log.info("Retrieved User by Id: " + retrievedUser);

		List<User> userList = userRepositorty.findAll();
		log.info("UserList is " + userList);

	}

}
