package com.learningportal.service;

import java.util.List;

import com.learningportal.entity.Course;

public interface CourseService {
	
	Course saveCourse(Course course);
	List<Course> getAllCourses();
	Course getById(long id);
	String Delete(long id);
	Course updateCourse(long id,Course course);

}
