package com.learningportal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "`user`")//User is a reserved word, use @Table(name = "`user`") (the backticks will cause Hibernate to automatically use the datasource specific method of quoting object names), or use a different table name than a reserved word.
public class User {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	String userId;
	String name;
	long phoneNumber;
	String email;
	String password;
	String role;
	LocalDateTime accountCreatedTime;
	boolean status; //active or deactive
	
	
	
	

}
