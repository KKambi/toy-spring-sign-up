package com.hb.signup.course.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.hb.signup.course.Course;
import com.hb.signup.course.dao.CourseDao;
import com.hb.signup.record.RecordDao;
import com.hb.signup.sample.SampleDao;

@Repository("courseService")
public class CourseService implements ICourseService {
	
	@Autowired
	CourseDao dao;
	
	@Autowired
	SampleDao dao2;
	
	@Autowired
	RecordDao dao3;
	
	@Override
	public void courseRegister(String courseCode, String courseSubClass, 
			String courseName, 
			int courseTime1, int courseTime2, 
			String courseRoom, int courseCredit,
			String courseProf, String coursePre) {
		dao.courseInsert(courseCode, courseSubClass, courseName, 
				courseTime1, courseTime2, 
				courseRoom, courseCredit, courseProf, coursePre);
	}

	@Override
	public Course courseSearch(String courseCode) {
		Course course = dao.courseSelect(courseCode);
		return course;
	}
	
	@Override
	public void sampleRegister(ClassPathResource file) {
		dao2.sampleInsert(file);
	}
	
	@Override
	public void recordRegister(ClassPathResource file) {
		dao3.recordInsert(file);
	}
	
	@Override
	public HashMap<String, Course> sampleSearch(){
		return dao2.sampleSelect();
	};
	
	@Override
	public HashMap<String, Course> recordSearch(){
		return dao3.recordSelect();
	};
}
