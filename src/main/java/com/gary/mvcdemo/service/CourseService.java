package com.gary.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.gary.mvcdemo.model.Course;

@Service
public interface CourseService {
	
	Course getCoursebyId(Integer courseId);
	
}
