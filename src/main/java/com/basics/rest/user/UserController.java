package com.basics.rest.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}

	// exceptional handling if resource not found
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User userResponse = service.findOne(id);

		if (userResponse == null)
			throw new UserNotFoundException("id :-" + id);

		return userResponse;
	}

	// Return status created
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		service.save(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
	
	// delete user by ID
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		User userResponse = service.deleteById(id);

		if (userResponse == null)
			throw new UserNotFoundException("id :-" + id);

	}

}
