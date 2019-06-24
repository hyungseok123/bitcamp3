<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>LoginPage</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#member_id').on("propertychange change keyup paste input",function(){
				var oldVal;
				var currentval = $(this).val();
				if(currentval == oldVal) {
					return;
				}
				oldVal = currentval;
				var textposition = $(this).next();
				$.ajax({
					url:"insert.js"
					,data: {member_id:currentval}
					,type: "post"
					,dataType:"json"
					,success:function(data){
						console.log('성공');
						var result = JSON.stringify(data); // 제이슨 객체를 String으로 변환
						if(result=='{"result":true}') {
							textposition.text('이미 사용중이거나 탈퇴한 아이디입니다.');
						}
						else {
							textposition.text('필수 입력정보입니다.');
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
		section {
			width: 460px;
			/*background-color: antiquewhite;*/
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
<header>
</header>
<section>
	<a href="https://www.naver.com"><h1 id="title">Bit Cafe</h1></a>
	<form>
		<label for="member_id">아이디</label>
		<input type="text" id="member_id" name="memeber_id" required >
		<div class="input_undertext">필수정보입니다.</div>
		<label for="member_pwd">비밀번호</label>
		<input type="password" id="member_pwd" name="memeber_pwd" required >
		<div class="input_undertext">필수정보입니다.</div>
		<label for="member_name">이름</label>
		<input type="text" id="member_name" name="member_name" required >
		<div class="input_undertext">필수정보입니다.</div>
		<label for="member_pwd">닉네임</label>
		<input type="text" id="member_nickname" name="member_nickname" required>
		<div class="input_undertext">필수정보입니다.</div>
		<input type="submit" value="제출" id="submit">
	</form>
</section>
</body>
</html>