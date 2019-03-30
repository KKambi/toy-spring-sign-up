<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="login">
		<form action="/courseRegister" method="get">
			학번 : <input type="text" name="memId" ><br />
			<input type="submit" value="로그인" >
		</form>
	</div>
</body>
</html>