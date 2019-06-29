<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="http://localhost:8080/bitcampcafe/javascript/loginjs/memberinsertpage.js"></script>
	<link rel="stylesheet" href="http://localhost:8080/bitcampcafe/css/logincss/memberinsertupdatepage.css">
</head>
<body>
<section>
	<a href="login.do"><h1 id="title">BITCAMP CAFE</h1></a>
	<form method="post" action="memberinsertresult.do">
		<label for="member_id">아이디</label>
		<input type="text" id="member_id" name="member_id" required >
		<div class="input_undertext"></div>
		<label for="member_pwd1">비밀번호</label>
		<input type="password" id="member_pwd1" name="member_pwd1" required >
		<div class="input_undertext"></div>
		<label for="member_pwd2">비밀번호 확인</label>
		<input type="password" id="member_pwd2" name="member_pwd2" required >
		<div class="input_undertext"></div>
		<label for="member_nickname">닉네임</label>
		<input type="text" id="member_nickname" name="member_nickname" required>
		<div class="input_undertext"></div>
		<input type="submit" value="회원가입" id="submit">
	</form>
</section>
</body>
</html>