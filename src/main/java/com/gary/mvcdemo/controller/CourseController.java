package com.gary.mvcdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gary.mvcdemo.model.Course;
import com.gary.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	private CourseService courseService;
	private static Logger log = LoggerFactory.getLogger(CourseController.class);
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	//本方法将处理/courses/view?courseId=123 只负责处理get的请求
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model){
		log.debug("In viewCourse,courseId = {}",courseId);
		Course course = courseService.getCoursebyId(courseId);
		model.addAttribute(course);
		return "course_overview";
	}
}
