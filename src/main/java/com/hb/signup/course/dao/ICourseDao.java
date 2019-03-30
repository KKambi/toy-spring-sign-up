package com.hb.signup.course.dao;

import com.hb.signup.course.Course;

public interface ICourseDao {

	void courseInsert(String courseCode, String courseSubClass, String courseName, 
			int courseTime1, int courseTime2, 
			String courseRoom, int courseCredit,
			String courseProf, String coursePre);

	Course courseSelect(String courseCode);

}