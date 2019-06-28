<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.aside_information {
		height: 200px;
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
        <li>닉네임 : ${memberInfo.member_nickname }</li>
        <li>내가 쓴 게시글 : ${myboard }</li>
        <li>내가 쓴 댓글 : ${mycomment }</li>
      </ul>
    </c:when>
    <c:otherwise>
      로그인 정보가 없습니다.
    </c:otherwise>
  </c:choose>
  </div>
</body>
</html>