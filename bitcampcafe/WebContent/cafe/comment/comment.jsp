<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment</title>
</head>
<body>
<div class="box-reply2 bg-color u_cbox" id="3udpB"><ul>
<c:forEach var="list" items="${list }">
	<li><c:out value="${list.member_nickname }"/></li>
	<li><c:out value="${list.comment_content }"/></li>
	<li><c:out value="${list.comment_writedate }"/></li>
</c:forEach>
</ul>
</div>
	<jsp:include page="commentinsert.jsp"></jsp:include>
</body>
</html>