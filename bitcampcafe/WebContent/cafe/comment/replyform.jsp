<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://localhost:8080/bitcampcafe/cafe/comment/tempcommentcss.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="commentreply">
 	    <form id="replyform" method="post" action="commentinsert.do">
    	  <textarea name="content" cols="100" rows="5"></textarea>
    	  <input type="hidden" name="parent" value="${dto.comment_parent }">
      	  <input type="hidden" name="depth" value="1">
      	  <input type="hidden" name="board_no" value="${dto.board_no }">
    	  <input type="hidden" name="member_no" value="${loginNo.member_no }">
    	  <input id="submitbutton" type="submit" value="등록">
	    </form>
	</div>
</body>
</html>