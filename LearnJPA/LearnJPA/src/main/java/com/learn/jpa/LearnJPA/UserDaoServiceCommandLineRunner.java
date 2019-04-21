/**
 * 
 */
package com.learn.jpa.LearnJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.jpa.LearnJPA.entity.User;
import com.learn.jpa.LearnJPA.service.UserDaoService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {
	public static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	@Autowired
	UserDaoService userDaoService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Gurman", "SE");
		userDaoService.save(user);
		log.info("New User Created " + user);
	}

}
