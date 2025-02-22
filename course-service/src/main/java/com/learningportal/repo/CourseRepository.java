package com.learningportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningportal.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{

}
