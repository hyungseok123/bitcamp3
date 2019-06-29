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