<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function logout() {
		location.href="logout.do";
	}
	
	function membermodify() {
		location.href="memberupdate.do";
	}
	
	function memberdrop() {
		if(confirm('탈퇴하시겠습니까?')){
			location.href="memberdelete.do";
		}
		else {
			return;
		}
	}
</script>
<style>
	.aside_information {
		height: 210px;
		padding: 10px 0;
	}
	
	#myactionbox1 {
		width: 48px;
		height: 48px;
		display: inline-block;
		vertical-align: middle;
		text-align: center;
		font-size: 30px;
		color: #03c75a;
		border: 1px solid silver;
		border-radius: 24px;
	}
	
	#myactionbox2 {
		width: 138px;
		height: 50px;
		display: inline-block;
		vertical-align: middle;
		font-weight: bold;
		padding-left: 10px;
	}
	#myactionmodify {
		margin-top: 8px;
	}
	#myactionmodify li button{
		width: 100%;
		height: 25px;	
		border:1px solid #03c75a;		
		background-color: white;
		font-family: 'Cambria';
		border-radius:10px;
		padding-bottom: 14px;
	}	
	
	#myactionmodify li button:hover{
	background-color: #03c75a;
	}
	
	#myactionmemberjoin {
		font-size: 14px;
		color: gray;
	}
	
	.memberinfotext {
		font-size: 14px;
	}
	
	#aside_informationh3 {
		padding-bottom: 5px;
		padding-left: 10px;
		font-size: 1.17em;
		font-weight: bold;
		margin: 0;
	}
	.myInfo_ul {
		margin-bottom: 0;
	}
	#aside_informationhr{
		margin: 0;
		margin: 5px 0;
	}
</style>
</head>
<body>
  <div class="aside_information">
  <c:choose>
    <c:when test="${memberInfo != null }">
      <ul class="myInfo_ul">
        <li><h3 id="aside_informationh3">나의 활동</h3></li>
        <li><hr id="aside_informationhr"></li>
        <li>
        	<div id="myactionbox1">${memberInfo.member_no }</div><div id="myactionbox2">
        		<ul>
        			<li>${memberInfo.member_nickname }</li>
        			<li id="myactionmemberjoin">가입 ${memberInfo.member_joindate }</li>
        		</ul>
        	</div>
        </li>
        <li class="memberinfotext">내가 쓴 게시글 : ${myboard }</li>
        <li class="memberinfotext">내가 쓴 댓글 : ${mycomment }</li>
      </ul>
      <ul id="myactionmodify">
      	<li><button onclick="logout()">로그아웃</button></li>
      	<li><button onclick="membermodify()">회원수정</button></li>
      	<li><button onclick="memberdrop()">회원탈퇴</button></li>
      </ul>
    </c:when>
    <c:otherwise>
      <a href="login.do">로그인 부터 하세요</a>
    </c:otherwise>
  </c:choose>
  </div>
</body>
</html>