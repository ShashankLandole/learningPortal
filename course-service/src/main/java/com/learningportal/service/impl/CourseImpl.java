package com.learningportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.entity.Course;
import com.learningportal.repo.CourseRepository;
import com.learningportal.service.CourseService;

@Service
public class CourseImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course saveCourse(Course course) {
		Course courseSaved = courseRepository.save(course);
		return courseSaved;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> allCourse = courseRepository.findAll();
		return allCourse;
	}

	@Override
	public Course getById(long id) {
		Course courseById = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		return courseById;
	}

	@Override
	public String Delete(long id) {
		Course courseById = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		courseRepository.delete(courseById);
		return "Course deleted Successfully " + id;
		
	}

	@Override
	public Course updateCourse(long id, Course course) {
	    return courseRepository.findById(id)
	        .map(existingCourse -> {
	            existingCourse.setCourseTitle(course.getCourseTitle());
	            existingCourse.setDescription(course.getDescription());
	            existingCourse.setTutor(course.getTutor());
	            existingCourse.setPrice(course.getPrice());
	            existingCourse.setCategory(course.getCategory());
	            return existingCourse;
	        })
	        .orElseThrow(() -> new RuntimeException("Course ID not found"));
	}


}
