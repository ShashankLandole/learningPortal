package com.learningportal.serviceImpl;



import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.learningportal.entity.User;
import com.learningportal.exception.UserNotFoundException;
import com.learningportal.repo.UserRepo;
import com.learningportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User save(User user) {
		
		String userID = UUID.randomUUID().toString();
		user.setUserId(userID);
		
		return userRepo.save(user);
		 

	}

	@Override
	public User getUserbyUserId(String id) {
		User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found with : " + id));
		return user;
	}
	
	@Override
	public List<User> getAll() {
		List<User> allUser = userRepo.findAll();
		
		if(allUser.isEmpty()) {
			throw new UserNotFoundException("list is empty");
		}

		return allUser; 
	}

	@Override
	public User updateUser(String id,User user) {
		
		User DbUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found with : " + id));
		
		DbUser.setName(user.getName());
		DbUser.setEmail(user.getEmail());
		DbUser.setPhoneNumber(user.getPhoneNumber());
		DbUser.setPassword(user.getPassword());
		DbUser.setRole(user.getRole());
		DbUser.setStatus(true);
		DbUser.setAccountCreatedTime(user.getAccountCreatedTime());
		
		
		
		return userRepo.save(DbUser);
	}
	
	@Override
	public User partialUpdate(String id, Map<String, Object> fields) {
		User DbUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found with : " + id));
		
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(User.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, DbUser, value);
		});
		
		return userRepo.save(DbUser);
		
	}

	@Override
	public void deleteUser(String id) {
		
		User DbUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found with : " + id));
		userRepo.delete(DbUser);
		
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
