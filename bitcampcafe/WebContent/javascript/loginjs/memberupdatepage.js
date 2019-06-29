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
					url:"http://localhost:8080/bitcampcafe/memberidcheck.json"
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
					url:"http://localhost:8080/bitcampcafe/membernicknamecheck.json"
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
					alert('회원정보가 수정되었습니다. 다시 로그인 해주세요').one();
					$('form').submit();
				}
				else {
					event.preventDefault();
					alert('입력이 잘못되었거나 중복체크를 하지 않은 부분이 있습니다.');
				}
			});
		});