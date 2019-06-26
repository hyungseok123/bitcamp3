<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment</title>
</head>
<body>
<h1>COMMENT</h1>
<div class="box-reply2 bg-color u_cbox" id="3udpB"><ul>
<c:forEach var="list" items="${list }">
	<li id="commentlist">
	<c:out value="${list.member_nickname }"/>
	<c:out value="${list.comment_content }"/>
	<c:out value="${list.comment_writedate }"/>
	<c:out value="${list.comment_parent }"/>
	<c:out value="${list.comment_depth }"/>
	<c:out value="${list.comment_order }"/>
	<a href="commentlist.do?rno=${list.comment_no }"><button id="reply">댓글</button></a>
	<a href="commentlist.do?uno=${list.comment_no }"><button id="modify">수정</button></a>
	<a href="commentdelete.do?dno=${list.comment_no }"><button id="delete">삭제</button></a>
	<!-- 대댓글 기능 -->
	<c:if test="${param.rno == list.comment_no }">
	  <form method="post" action="commentinsert.do">
    	<textarea name="content" cols="100" rows="5"></textarea>
    	<input type="hidden" name="parent" value="${list.comment_parent }">
    	<input type="hidden" name="depth" value="1">
    	<input type="hidden" name="board_no" value="${list.board_no }">		<!-- 게시판 번호 :: 수정 필요 -->
    	<input type="hidden" name="member_no" value="${list.member_no }">	<!-- 회원번호    :: 수정 필요 -->
    	<input type="submit" value="등록">
	  </form>
	</c:if>
	<!-- 수정 기능 -->
	<c:if test="${param.uno == list.comment_no }">
	  <form method="post" action="commentupdate.do">
    	<textarea name="content" cols="100" rows="5">${list.comment_content }</textarea>
    	<input type="hidden" name="parent" value="${list.comment_parent }">
    	<input type="hidden" name="depth" value="1">
    	<input type="hidden" name="board_no" value="${list.board_no }">		<!-- 게시판 번호 :: 수정 필요 -->
    	<input type="hidden" name="member_no" value="${list.member_no }">	<!-- 회원번호    :: 수정 필요 -->
    	<input type="submit" value="등록">
	  </form>
	</c:if>
	</li>
</c:forEach>
</ul>
</div>
<div>
  <form method="post" action="commentinsert.do">
   	<textarea name="content" cols="100" rows="5"></textarea>
   	<input type="hidden" name="parent" value="0">
   	<input type="hidden" name="depth" value="0">
   	<input type="hidden" name="board_no" value="1">							<!-- 게시판 번호 :: 수정 필요 -->
   	<input type="hidden" name="member_no" value="1">						<!-- 회원 번호   :: 수정 필요 -->
   	<input type="submit" value="등록">
  </form>
</div>
</body>
</html>