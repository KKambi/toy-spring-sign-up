<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Map.Entry" %>
<%@ page import = "java.util.Arrays" %>
<%@ page import = "com.hb.signup.course.Course" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서강대학교 수강신청</title>
</head>
<body>
	<div class="logo">로고</div>
	<div class="title">서강대학교 수강신청</div>
	<div class="time">현재 시간 : ${serverTime} </div>
	<div class="memInfo">학번 : ${memId}</div>
	<a href="/courseRecord?memId=${memId}">수강이력</a>

	<!--1.저장되어있는 개설과목 정보를 불러오는 부분
		2.체크박스를 만들어 form으로 보낼 수 있도록 할 것 -->
	
	<form action="/courseCheck?memId=${memId}" method="post">
	<h2>현재 개설과목</h2>
		<table border="1">
			<tr>
				<th>코드</th>
				<th>이름</th>
				<th>시간</th>
				<th>강의실</th>
				<th>학점</th>
				<th>교수진</th>
				<th>선수과목</th>
				<th>신청</th>
			</tr>
		<c:forEach var="entry" items="${courseMap}">			
			<tr>
				<td>${entry.key}-${entry.value.getCourseSubClass()}</td>
				<td>${entry.value.getCourseName()}</td> 
				<td>${entry.value.getCourseTime()}</td>
				<td>${entry.value.getCourseRoom()}</td>
				<td>${entry.value.getCourseCredit()}</td>
				<td>${entry.value.getCourseProf()}</td>
				<td>${entry.value.getCoursePre()}</td>
				<td><input type="checkbox" name="checkedCourse" value="${entry.key}"></td>
			</tr>
		</c:forEach>
		
		</table>
		<input type="submit" value="신청하기" >
	</form>
	
</body>
</html>