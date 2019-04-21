package com.example.demo.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserServiceDB userServiceDB;
	
	//For Internationalization
	@Autowired
	private MessageSource messageSource;
	

	@GetMapping("/users")
	public List<User> getUsers() {
		return userServiceDB.getUsers();
	}

	@GetMapping("/users/{id}")
	public Resource<User> getUserById(@PathVariable int id) {
		Optional<User> user = userServiceDB.getUsers()
							  .stream()
							  .filter(u -> (u.getId() == id))
							  .findFirst();
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found with userId " + id);
		}
		/*
		 * HATEOAS is to provide other links with this response Suppose with this
		 * specific user info I want to send the link for all users method
		 */ 
		Resource<User> resource = new Resource<User>(user.get());
		
		//static import for ControllerLinkBuilder
		//LinkTo is method of ControllerLinkBuilder
		ControllerLinkBuilder links = 
				linkTo(methodOn(this.getClass()).getUsers());
		
		//all-users will the the name with which we can use it
		resource.add(links.withRel("all-users"));
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userServiceDB.saveUser(user);

		// for returning proper httpStatus
		URI location = ServletUriComponentsBuilder
					   .fromCurrentRequest().path("{id}")
					    .buildAndExpand(savedUser.getId())
				       .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userServiceDB.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("User not found with userId " + id);
		}
	}
	
	
	/*
	 * @GetMapping("/hello-world-internationalization") public String
	 * internationalizationFunc(@RequestHeader(name = "Accept-Language", required =
	 * false) Locale locale) { return
	 * messageSource.getMessage("good.morning.message", null, locale); }
	 */
	 
	
	
	@GetMapping("/hello-world-internationalization")
	public String internationalizationFunc() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	 

}
