package com.in28minutes.JpaHibernateAdvance.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.JpaHibernateAdvance.entity.Course;
import com.in28minutes.JpaHibernateAdvance.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

}
