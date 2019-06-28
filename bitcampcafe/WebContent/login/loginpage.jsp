<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
	$(document).ready(function(){
		$('form').on('submit',function(event){
			event.preventDefault();
			var member_id = document.getElementById("member_id").value;
			var member_pwd = document.getElementById("member_pwd").value;
			console.log("test :"+member_id);
			$.ajax({
				url:"http://localhost:8080/bitcampcafe/memberloginresult.json"
				,data: {member_id:member_id,member_pwd:member_pwd}
				,type: "post"
				,dataType:"json"
				,success:function(data){
					console.log('성공');
					var result = JSON.stringify(data); // 제이슨 객체를 String으로 변환
					console.log(result);
					if(result == null || result == "") {
						textposition.text('');
					}
					else if(result=='{"result":false}') { //로그인 실패 문구
						var position = $('.input_undertext');
						position.text('가입하지 않은 아이디 이거나 아이디 또는 비밀번호가 틀렸습니다.');
						position.css('color','red');
					}
					else { //로그인 성공하면 이동하는 페이지
						location.href="loginsuccess.do";
					}
				}
				,error:function(data){
					console.log('실패');
				}
			});
		});
	});
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
		
		.input_undertext {
			width: 460px;
			height: 15px;
			padding: 0;
			margin-bottom: 15px;
			font-size: 15px;
			color: red;	
		}
	</style>
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