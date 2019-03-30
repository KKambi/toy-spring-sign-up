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

 	<!--
		1.성공한 수강신청 정보를 출력하는 페이지 
	-->
	
	 <h2>수강신청 성공!</h2>
	 신청학점 : ${totalCredit}
	 <table border="1">
			<tr>
				<th>코드</th>
				<th>이름</th>
				<th>시간</th>
				<th>강의실</th>
				<th>학점</th>
				<th>교수진</th>
			</tr>
		<c:forEach var="entry" items="${registerMap}">			
			<tr>
				<td>${entry.key}-${entry.value.getCourseSubClass()}</td>
				<td>${entry.value.getCourseName()}</td> 
				<td>${entry.value.getCourseTime()}</td>
				<td>${entry.value.getCourseRoom()}</td>
				<td>${entry.value.getCourseCredit()}</td>
				<td>${entry.value.getCourseProf()}</td>
			</tr>
		</c:forEach>
		</table>
	
</body>
</html>