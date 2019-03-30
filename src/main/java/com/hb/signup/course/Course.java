package com.hb.signup.course;

//과목의 정보(과목코드, 과목명, 강의시간, 담당교수, 강의실, 선수과목코드)
public class Course {
	private String courseCode;
	private String courseSubClass;
	private String courseName;
	private int courseTime1;
	private int courseTime2;
	private String courseRoom;
	private int courseCredit;
	private String courseProf;
	private String coursePre;
	
	public String getCourseTime() {
		String ret = null;
		int time1 = courseTime1;
		int time2 = courseTime2;
		
		//1교시인 경우
		if (time2 == -1) {
			switch(time1) {
			case 0:
				ret="월 9:00~10:15";
				break;
			case 1:
				ret="월 10:30~11:45";
				break;
			case 2:
				ret="월 12:00~13:15";
				break;
			case 3:
				ret="월 13:30~14:45";
				break;
			case 4:
				ret="월 15:00~16:15";
				break;
			case 5:
				ret="월 16:30~17:45";
				break;
			case 6:
				ret="월 18:00~19:15";
				break;
			
			case 7:
				ret="화 9:00~10:15";
				break;
			case 8:
				ret="화 10:30~11:45";
				break;
			case 9:
				ret="화 12:00~13:15";
				break;
			case 10:
				ret="화 13:30~14:45";
				break;
			case 11:
				ret="화 15:00~16:15";
				break;
			case 12:
				ret="화 16:30~17:45";
				break;
			case 13:
				ret="화 18:00~19:15";
				break;

			case 14:
				ret="수 9:00~10:15";
				break;
			case 15:
				ret="수 10:30~11:45";
				break;
			case 16:
				ret="수 12:00~13:15";
				break;
			case 17:
				ret="수 13:30~14:45";
				break;
			case 18:
				ret="수 15:00~16:15";
				break;
			case 19:
				ret="ㅍ 16:30~17:45";
				break;
			case 20:
				ret="수 18:00~19:15";
				break;
				
			case 21:
				ret="목 9:00~10:15";
				break;
			case 22:
				ret="목 10:30~11:45";
				break;
			case 23:
				ret="목 12:00~13:15";
				break;
			case 24:
				ret="목 13:30~14:45";
				break;
			case 25:
				ret="목 15:00~16:15";
				break;
			case 26:
				ret="목 16:30~17:45";
				break;
			case 27:
				ret="목 18:00~19:15";
				break;
				
			case 28:
				ret="금 9:00~10:15";
				break;
			case 29:
				ret="금 10:30~11:45";
				break;
			case 30:
				ret="금 12:00~13:15";
				break;
			case 31:
				ret="금 13:30~14:45";
				break;
			case 32:
				ret="금 15:00~16:15";
				break;
			case 33:
				ret="금 16:30~17:45";
				break;
			case 34:
				ret="금 18:00~19:15";
				break;
				
			case 35:
				ret="토 9:00~10:15";
				break;
			case 36:
				ret="토 10:30~11:45";
				break;
			case 37:
				ret="토 12:00~13:15";
				break;
			case 38:
				ret="토 13:30~14:45";
				break;
			case 39:
				ret="토 15:00~16:15";
				break;
			case 40:
				ret="토 16:30~17:45";
				break;
			case 41:
				ret="토 18:00~19:15";
				break;
			}
		}
		
		//2교시 하루2타임인경우
		else if(time2 - time1 == 1) {
			switch(time1) {
			case 0:
				ret="월 9:00~11:45";
				break;
			case 1:
				ret="월 10:30~13:15";
				break;
			case 2:
				ret="월 12:00~14:45";
				break;
			case 3:
				ret="월 13:30~16:15";
				break;
			case 4:
				ret="월 15:00~17:45";
				break;
			case 5:
				ret="월 16:30~19:15";
				break;
			
			case 7:
				ret="월 9:00~11:45";
				break;
			case 8:
				ret="월 10:30~13:15";
				break;
			case 9:
				ret="월 12:00~14:45";
				break;
			case 10:
				ret="월 13:30~16:15";
				break;
			case 11:
				ret="월 15:00~17:45";
				break;
			case 12:
				ret="월 16:30~19:15";
				break;
				
			case 14:
				ret="월 9:00~11:45";
				break;
			case 15:
				ret="월 10:30~13:15";
				break;
			case 16:
				ret="월 12:00~14:45";
				break;
			case 17:
				ret="월 13:30~16:15";
				break;
			case 18:
				ret="월 15:00~17:45";
				break;
			case 19:
				ret="월 16:30~19:15";
				break;
				
			case 21:
				ret="월 9:00~11:45";
				break;
			case 22:
				ret="월 10:30~13:15";
				break;
			case 23:
				ret="월 12:00~14:45";
				break;
			case 24:
				ret="월 13:30~16:15";
				break;
			case 25:
				ret="월 15:00~17:45";
				break;
			case 26:
				ret="월 16:30~19:15";
				break;
				
			case 28:
				ret="월 9:00~11:45";
				break;
			case 29:
				ret="월 10:30~13:15";
				break;
			case 30:
				ret="월 12:00~14:45";
				break;
			case 31:
				ret="월 13:30~16:15";
				break;
			case 32:
				ret="월 15:00~17:45";
				break;
			case 33:
				ret="월 16:30~19:15";
				break;
				
			case 35:
				ret="월 9:00~11:45";
				break;
			case 36:
				ret="월 10:30~13:15";
				break;
			case 37:
				ret="월 12:00~14:45";
				break;
			case 38:
				ret="월 13:30~16:15";
				break;
			case 39:
				ret="월 15:00~17:45";
				break;
			case 40:
				ret="월 16:30~19:15";
				break;
			}
		}
		
		//2교시, 하루1타임인 경우
		else {
			switch(time1) {
			case 0:
				ret="월,수 9:00~10:15";
				break;
			case 1:
				ret="월,수 10:30~11:45";
				break;
			case 2:
				ret="월,수 12:00~13:15";
				break;
			case 3:
				ret="월,수 13:30~14:45";
				break;
			case 4:
				ret="월,수 15:00~16:15";
				break;
			case 5:
				ret="월,수 16:30~17:45";
				break;
			case 6:
				ret="월,수 18:00~19:15";
				break;
			
			case 7:
				ret="화,목 9:00~10:15";
				break;
			case 8:
				ret="화,목 10:30~11:45";
				break;
			case 9:
				ret="화,목 12:00~13:15";
				break;
			case 10:
				ret="화,목 13:30~14:45";
				break;
			case 11:
				ret="화,목 15:00~16:15";
				break;
			case 12:
				ret="화,목 16:30~17:45";
				break;
			case 13:
				ret="화,목 18:00~19:15";
				break;
				
			case 14:
				ret="수,금 9:00~10:15";
				break;
			case 15:
				ret="수,금 10:30~11:45";
				break;
			case 16:
				ret="수,금 12:00~13:15";
				break;
			case 17:
				ret="수,금 13:30~14:45";
				break;
			case 18:
				ret="수,금 15:00~16:15";
				break;
			case 19:
				ret="수,금 16:30~17:45";
				break;
			case 20:
				ret="수,금 18:00~19:15";
				break;
			}
		}
		return ret;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getCourseTime1() {
		return courseTime1;
	}
	public void setCourseTime1(int courseTime1) {
		this.courseTime1 = courseTime1;
	}
	public int getCourseTime2() {
		return courseTime2;
	}
	public void setCourseTime2(int courseTime2) {
		this.courseTime2 = courseTime2;
	}
	public String getCourseProf() {
		return courseProf;
	}
	public void setCourseProf(String courseProf) {
		this.courseProf = courseProf;
	}
	public String getCourseRoom() {
		return courseRoom;
	}
	public void setCourseRoom(String courseRoom) {
		this.courseRoom = courseRoom;
	}
	public String getCourseSubClass() {
		return courseSubClass;
	}
	public void setCourseSubClass(String courseSubClass) {
		this.courseSubClass = courseSubClass;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public String getCoursePre() {
		return coursePre;
	}
	public void setCoursePre(String CoursePre) {
		this.coursePre = CoursePre;
	}
	
}
