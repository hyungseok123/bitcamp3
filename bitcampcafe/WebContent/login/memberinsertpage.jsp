<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
	var memberIdCheck = false;
	var memberPwd1Check = false;
	var memberPwd2Check = false;
	var memberNicknameCheck = false;
	var pwdBuffer = "";
	
		$(document).ready(function(){
			$('#member_id').on("focusout",function(){
				var currentval = $(this).val();
				var textposition = $(this).next();
				$.ajax({
					url:"../memberidcheck.json"
					,data: {member_id:currentval}
					,type: "post"
					,dataType:"json"
					,success:function(data){
						console.log('성공');
						var result = JSON.stringify(data); // 제이슨 객체를 String으로 변환
						if(currentval == null || currentval == "") {
							textposition.text('필수 입력정보입니다.');
							textposition.css('color','red');
							memberIdCheck = false;
						}
						else if(result=='{"result":true}') {
							textposition.text('이미 사용중인 아이디입니다.');
							textposition.css('color','red');
							memberIdCheck = false;
						}
						else {
							textposition.text('사용 가능한 아이디입니다.');
							textposition.css('color','#03c75a');
							memberIdCheck = true;
						}
					}
					,error:function(data){
						console.log('실패');
					}
				});
			});
			
			$('#member_pwd1').on("focusout",function(){
				var currentval = $(this).val();
				var textposition = $(this).next();
				if(currentval == null || currentval == "") {
					textposition.text('필수 입력정보입니다.');
					textposition.css('color','red');
					memberPwd1Check = false;
				}
				else {
					textposition.text('사용가능한 비밀번호 입니다.');
					textposition.css('color','#03c75a');
					pwdBuffer = currentval;
					memberPwd1Check = true;
				}
			});
			
			$('#member_pwd2').on("focusout",function(){
				var currentval = $(this).val();
				var textposition = $(this).next();
				if(currentval == null || currentval == "") {
					textposition.text('필수 입력정보입니다.');
					textposition.css('color','red');
					memberPwd2Check = false;
				}
				else if(pwdBuffer != currentval) {
					textposition.text('비밀번호가 일치하지 않습니다.');
					textposition.css('color','red');
					memberPwd2Check = false;
				}
				else {
					textposition.text('비밀번호가 일치합니다.');
					textposition.css('color','#03c75a');
					memberPwd2Check = true;
				}
			});
			
			$('#member_nickname').on("focusout",function(){
				var currentval = $(this).val();
				var textposition = $(this).next();
				$.ajax({
					url:"../membernicknamecheck.json"
					,data: {member_nickname:currentval}
					,type: "post"
					,dataType:"json"
					,success:function(data){
						console.log('성공');
						var result = JSON.stringify(data); // 제이슨 객체를 String으로 변환
						if(currentval == null || currentval == "") {
							textposition.text('필수 입력정보입니다.');
							textposition.css('color','red');
							memberNicknameCheck = false;
						}
						else if(result=='{"result":true}') {
							textposition.text('이미 사용중인 닉네임입니다.');
							textposition.css('color','red');
							memberNicknameCheck = false;
						}
						else {
							textposition.text('사용 가능한 닉네임입니다.');
							textposition.css('color','#03c75a');
							memberNicknameCheck = true;
						}
					}
					,error:function(data){
						console.log('실패');
					}
				});
			});		
			
			$('form').on('submit',function(event){
				if(memberIdCheck==true && memberPwd1Check==true && memberPwd2Check==true && memberNicknameCheck==true) {
					alert('회원가입을 축하드립니다.').one();
					$('form').submit();
				}
				else {
					event.preventDefault();
					alert('입력하신 부분에 잘못된 부분이 있습니다.');
				}
			});
		});
	</script>
	<style>
		section {
			width: 460px;
			margin: 0 auto;
		}
		
		#title {
			color: #03c75a;
			font-size: 50px;
			text-align: center;
			font-weight: 900;
		}
		
		a {
			text-decoration: none;
		}
		
		input {
			width: 428px;
			height: 30px;
			margin: 5px 0;
			padding: 10px 15px;
			border: 1px solid silver;
			font-size: 30px;
		}
		
		label {
			width: 460px;
			height: 20px;
			font-size: 20px;
			font-weight: 900;
			margin-bottom: 10px;
		}
		
		#submit {
			width: 460px;
			height: 70px;
			background-color: #03c75a;
			color: white;
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
<section>
	<a href="https://www.naver.com"><h1 id="title">Bit Cafe</h1></a>
	<form method="post" action="../memberinsertresult.do">
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