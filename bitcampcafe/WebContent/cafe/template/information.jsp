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
		height: 200px;
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
		width: 148px;
		height: 50px;
		display: inline-block;
		vertical-align: middle;
		font-weight: bold;
	}
	#myactionmodify {
		margin-top: 8px;
	}
	#myactionmodify li button{
		width: 100%;
		height: 25px;
		border-top: 1px solid silver;
		background-color: white;
	}
	
	#myactionmemberjoin {
		font-size: 14px;
		color: gray;
	}
</style>
</head>
<body>
  <div class="aside_information">
  <c:choose>
    <c:when test="${memberInfo != null }">
      <ul>
        <li><h3>나의 활동</h3></li>
        <li><hr></li>
        <li>
        	<div id="myactionbox1">${memberInfo.member_no }</div><div id="myactionbox2">
        		<ul>
        			<li>${memberInfo.member_nickname }</li>
        			<li id="myactionmemberjoin">가입 ${memberInfo.member_joindate }</li>
        		</ul>
        	</div>
        </li>
        <li>내가 쓴 게시글 : ${myboard }</li>
        <li>내가 쓴 댓글 : ${mycomment }</li>
      </ul>
      <ul id="myactionmodify">
      	<li><button onclick="logout()">로그아웃</button></li>
      	<li><button onclick="membermodify()">회원수정</button></li>
      	<li><button onclick="memberdrop()">회원탈퇴</button></li>
      </ul>
    </c:when>
    <c:otherwise>
      로그인 정보가 없습니다.
    </c:otherwise>
  </c:choose>
  </div>
</body>
</html>