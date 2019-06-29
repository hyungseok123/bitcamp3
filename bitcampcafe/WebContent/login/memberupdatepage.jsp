<%@page import="com.bitcafe.DTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://localhost:8080/bitcampcafe/javascript/loginjs/memberupdatepage.js"></script>
<link rel="stylesheet" href="http://localhost:8080/bitcampcafe/css/logincss/memberinsertupdatepage.css">
</head>
<body>
<section>
<c:set var="memberdto" value="${sessionScope.memberdto}"/>
<c:if test="${memberdto != null }">
	<a href="login.do"><h1 id="title">BITCAMP CAFE</h1></a>
	<form method="post" action="memberupdateresult.do">
		<label for="member_id">아이디 수정</label>
		<input type="text" id="member_id" name="member_id" value="<c:out value="${memberdto.member_id }"/>" required>
		<div class="input_undertext">클릭해서 중복체크를 해주세요</div>
		<label for="member_pwd1">비밀번호 수정</label>
		<input type="password" id="member_pwd1" name="member_pwd1" required >
		<div class="input_undertext"></div>
		<label for="member_pwd2">비밀번호 확인</label>
		<input type="password" id="member_pwd2" name="member_pwd2" required >
		<div class="input_undertext"></div>
		<label for="member_nickname">닉네임 수정</label>
		<input type="text" id="member_nickname" name="member_nickname" value="<c:out value="${memberdto.member_nickname }"/>" required>
		<div class="input_undertext">클릭해서 중복체크를 해주세요</div>
		<input type="submit" value="수정완료" id="submit">
	</form>
</c:if>
<c:if test="${memberdto == null }"> <!-- 로그인을 하지 않으면 이동 -->
	<jsp:include page="loginpage.jsp"/>
</c:if>
</section>
</body>
</html>