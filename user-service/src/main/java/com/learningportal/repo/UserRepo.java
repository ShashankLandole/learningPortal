package com.learningportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
 