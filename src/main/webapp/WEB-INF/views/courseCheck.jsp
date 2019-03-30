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

	<!--1.신청을 실패하여 사유를 보여주는 화면 -->
	
	<div class="fail">
		${creditResult}
	</div>
	<div class="fail">
		${timeResult}
	</div>
	<div class="fail">	
		${preResult}
	</div>
	
	<a href="/courseRegister?memId=${memId}">뒤로가기</a>
	
</body>
</html>