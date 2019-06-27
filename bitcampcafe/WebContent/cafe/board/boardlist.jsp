<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center"></div>
	<h1>게시글 목록</h1>
		<table>
			<c:forEach var="data" items="${requestScope.list }">
				<tr>
				  <td>${data.board_no }</td>
				  <td><a href="boarddetail.do?no=${data.board_no }"><c:out default="null" value="${data.board_title }"></c:out></a></td>
				  <td><c:out default="null" value="${data.member_nickname }"></c:out></td>
				  <td><c:out default="null" value="${data.board_writedate }"></c:out></td>
				  <td><c:out default="null" value="${data.board_viewcount }"></c:out></td>
				</tr>
				<tr align="center" valign="baseline">
				  <td colspan="4">
				  </td>
				  <td colspan="1"> 
					 <a href="boardinsert.do"><button>글쓰기</button></a>  
				  </td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>