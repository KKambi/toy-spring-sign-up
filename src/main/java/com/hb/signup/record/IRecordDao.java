package com.hb.signup.record;

import java.util.HashMap;

import org.springframework.core.io.ClassPathResource;

import com.hb.signup.course.Course;

public interface IRecordDao {
	
	void recordInsert(ClassPathResource file);
	HashMap<String, Course> recordSelect();
}
