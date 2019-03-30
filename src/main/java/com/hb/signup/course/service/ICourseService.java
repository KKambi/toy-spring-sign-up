package com.hb.signup.course.service;

import java.util.HashMap;

import org.springframework.core.io.ClassPathResource;

import com.hb.signup.course.Course;

public interface ICourseService {

	void courseRegister(String courseCode, String courseSubClass, 
			String courseName, 
			int courseTime1, int courseTime2, 
			String courseRoom, int courseCredit,
			String courseProf, String coursePre);

	Course courseSearch(String courseCode);

	void sampleRegister(ClassPathResource file);
	
	void recordRegister(ClassPathResource file);
	
	HashMap<String, Course> sampleSearch();
	
	HashMap<String, Course> recordSearch();
}