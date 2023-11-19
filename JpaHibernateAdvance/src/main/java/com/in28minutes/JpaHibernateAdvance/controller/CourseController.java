package com.in28minutes.JpaHibernateAdvance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.in28minutes.JpaHibernateAdvance.entity.Course;
import com.in28minutes.JpaHibernateAdvance.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(method=RequestMethod.GET,name="/getAll")
	public String getAll(ModelMap model) {
		List<Course> courseList = courseService.getAllCourse();
		model.put("course", courseList);
		return "/CourseList";
	}
}
