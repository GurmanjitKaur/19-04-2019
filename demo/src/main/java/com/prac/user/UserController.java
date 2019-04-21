/**
 * 
 */
package com.prac.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author M1037484
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserServiceDB userServiceDB;
	
	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return userServiceDB.getUsers();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id){
		return (User)userServiceDB.getUsers().stream().filter(u -> (u.getId() == id));
	}
	
	@PostMapping("/users")
	public void saveUser(@RequestBody User user){
		userServiceDB.saveUser(user);
	}
}
