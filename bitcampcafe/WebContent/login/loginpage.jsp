<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		function send() {
			location.href="memberinsert.do";
		}
	</script>
	<style>
		section{
			width: 460px;
			margin: 0 auto;
		}
		
		#title{
			color: #03c75a;
			font-size: 50px;
			text-align: center;
			font-weight: 900;
		}
		
		a{
			text-decoration: none;
		}
		
		input{
			width: 428px;
			height: 30px;
			margin-bottom: 15px;
			padding: 10px 15px;
			border: 1px solid silver;
			font-size: 30px;
		}
		
		#submit{
			width: 460px;
			height: 70px;
			background-color: #03c75a;
			text-align: center;
			padding-top: 10px;
			margin-bottom: 15px;
			color: white;
			font-size: 30px;
		}
		
		#undertext {
			width: 460px;
			height: 30px;
			font-size: 20px;
			text-align: center;
		}
		
		#undertext a{
			color: gray;
			margin: 0 15px;
		}
		
		#undertext a:hover{
			text-decoration: underline;
		}
		
		.line{
			border: 1px solid gray;
			margin-bottom: 15px;
		}
		
		input:focus {
			border: 2px solid #03c75a;
			width: 426px;
			height: 28px;
		}
	</style>
</head>
<body>
<header>
</header>
<section>
	<a href="https://www.naver.com"><h1 id="title">Bit Cafe</h1></a>
	<form>
		<input type="text" id="member_id" name="memeber_id" required placeholder="아이디">
		<input type="password" id="member_pwd" name="memeber_pwd" required placeholder="비밀번호">
		<input type="submit" value="로그인" id="submit">
	</form>
	<div class="line"></div>
	<div id="undertext">
		<a href="../memberinsert.do" id="loginsert">회원가입</a>
		<a href="#">회원탈퇴</a>
	</div>
</section>
</body>
</html>