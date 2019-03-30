package com.hb.signup.course.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.hb.signup.course.Course;


@Repository("courseDao")
public class CourseDao implements ICourseDao {
	private HashMap<String, Course> dbMap;
	
	public CourseDao() {
		dbMap = new HashMap<String, Course>();
	}
	
	@Override
	public void courseInsert(String courseCode, String courseSubClass, 
			String courseName, 
			int courseTime1, int courseTime2, 
			String courseRoom, int courseCredit,
			String courseProf, String coursePre) {
		Course course = new Course();
		course.setCourseCode(courseCode);
		course.setCourseSubClass(courseSubClass);
		course.setCourseName(courseName);
		course.setCourseTime1(courseTime1);
		course.setCourseTime2(courseTime2);
		course.setCourseRoom(courseRoom);
		course.setCourseCredit(courseCredit);
		course.setCourseProf(courseProf);
		course.setCoursePre(coursePre);
		
		dbMap.put(courseCode, course);
		
	}

	@Override
	public Course courseSelect(String courseCode) {
		Course course = dbMap.get(courseCode);
		
		return course;
	}

	
}
