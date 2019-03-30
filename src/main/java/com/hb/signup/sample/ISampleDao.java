package com.hb.signup.sample;

import java.util.HashMap;

import org.springframework.core.io.ClassPathResource;

import com.hb.signup.course.Course;

public interface ISampleDao {
	
	void sampleInsert(ClassPathResource file);
	HashMap<String, Course> sampleSelect();
}
