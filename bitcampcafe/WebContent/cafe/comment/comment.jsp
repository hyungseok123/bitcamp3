<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment</title>
</script>
</head>
<body>
<div class="box-reply2 bg-color u_cbox" id="3udpB"><ul>
<c:forEach var="list" items="${list }">
	<li id="commentlist">
	<c:out value="${list.member_nickname }"/>
	<c:out value="${list.comment_content }"/>
	<c:out value="${list.comment_writedate }"/>
	<c:out value="${list.comment_parent }"/>
	<c:out value="${list.comment_depth }"/>
	<c:out value="${list.comment_order }"/>
	<a href="commentlist.do?no=${list.comment_parent }"><button id="reply">댓글</button></a>
	<a href="commentupdate.do?no=${list.comment_no }"><button id="modify">수정</button></a>
	<a href="commentdelete.do?no=${list.comment_no }"><button id="delete">삭제</button></a>
	<c:if test="${param.no == list.comment_parent }">
	  <form method="post" action="commentinsert.do">
    	<textarea name="content" cols="100" rows="5"></textarea>
    	<input value="${list.boardno }">
    	<input value="${list.memberno }">
    	<input value="${list.comment_parent }">
    	<input type="submit" value="등록">
	  </form>
	</c:if>
	</li>
</c:forEach>
</ul>
</div>
	<jsp:include page="commentinsert.jsp"></jsp:include>
</body>
</html>