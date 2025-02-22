package com.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.entity.Course;
import com.learningportal.service.CourseService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public Course saveCourse(@RequestBody Course course) {
		Course saveCourse = courseService.saveCourse(course);
		return saveCourse;
		
	}
	
	@GetMapping
	public List<Course> getAllCourse(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable long id) {
		Course courseById = courseService.getById(id);
		
		return courseById;
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		String deleteCourse = courseService.Delete(id);
		return deleteCourse;
	}
	
	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable long id, @RequestBody Course course) {
		//Course courseById = courseService.getById(id);
		
		
		return courseService.updateCourse(id, course);
	}

}
