<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="http://localhost:8080/bitcampcafe/javascript/loginjs/loginpage.js"></script>
	<link rel="stylesheet" href="http://localhost:8080/bitcampcafe/css/logincss/loginpage.css">
</head>
<body>
<header>
</header>
<section>
	<a href="login.do"><h1 id="title">BITCAMP CAFE</h1></a>
	<form id="frm" name="frm" method="post">
		<input type="text" id="member_id" name="member_id" required placeholder="아이디">
		<input type="password" id="member_pwd" name="member_pwd" required placeholder="비밀번호">
		<div class="input_undertext"></div>
		<input type="submit" value="로그인" id="submit">
	</form>
	<div class="line"></div>
	<div id="undertext">
		<a href="memberinsert.do" id="loginsert">회원가입</a>
	</div>
</section>
</body>
</html>