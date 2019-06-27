<%@page import="com.bitcafe.DTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 페이지</title>
</head>
<body>
<h1>테스트 페이지(main연결하면 삭제할것)</h1>
<c:set var="dto" value="${sessionScope.memberInfo }"/>
<c:if test="${dto != null}">
	번호 : <c:out value="${dto.member_no }"/><br>
	닉네임 : <c:out value="${dto.member_nickname }"/><br>
	가입날짜 : <c:out value="${dto.member_joindate }"/><br>
</c:if>
<a href="memberupdate.do">회원수정</a>
<a href="memberdelete.do">회원탈퇴</a>
<a href="logout.do">로그아웃</a>
<div>
	<a href="boardlist.do">메인으로</a>
</div>
</body>
</html>