package com.learningportal.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.learningportal.entity.User;
import com.learningportal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		//User save = userService.save(user);
		//return new ResponseEntity<User>(save,HttpStatus.OK);
		return new ResponseEntity<User>( userService.save(user),HttpStatus.OK);
	
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserByUserId(@PathVariable String id) {
		User userbyUserId = userService.getUserbyUserId(id);
		
		return new ResponseEntity<User>(userbyUserId,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> allUser = userService.getAll();
		
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateuser(@PathVariable String id,@RequestBody User user) {
		User updateUser = userService.updateUser(id, user);
		
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<User> partialUpdate(@PathVariable String id, @RequestBody Map<String, Object> fields){
		
		User partialUpdate = userService.partialUpdate(id,fields);
		
		return new ResponseEntity<User>(partialUpdate,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("User with ID " + id + " has been deleted successfully."); // Return success message
		
	}
}
