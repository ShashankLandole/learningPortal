package com.learningportal.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learningportal.entity.User;


public interface UserService {
	
	User save(User user);
	User getUserbyUserId(String id);
	List<User> getAll();
	  User updateUser(String  id,User user);
	  
	  //implement pagination
	  void deleteUser(String  id);
	  
	  User getByEmail(String email);
	//method for partial update
	User partialUpdate(String id, Map<String, Object> fields);

}
