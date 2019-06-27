<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://localhost:8080/bitcampcafe/cafe/comment/tempcommentcss.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.updateformborder {
		border-bottom: 1px solid silver;
		height: 95px;
	}
</style>
</head>
<body>
<c:out value="${dto.member_nickname }"></c:out>
<c:out value="${dto.comment_writedate }"></c:out>
<div class="updateformborder">
  <form id="updateform" method="post" action="commentupdateresult.do">
   	<textarea name="content" cols="100" rows="5">${dto.comment_content }</textarea>
   	<input type="hidden" name="comment_no" value="${dto.comment_no }">
   	<input type="hidden" name="board_no" value="${dto.board_no }">
   	<input id="submitbutton" type="submit" value="등록">
  </form>
</div>
</body>
</html>