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
	<form method="post" action="boardinsert.do">
		<input type="hidden" name="command" value="board_write">
		<table>
			<c:forEach var="data" items="${requestScope.list }">
				<tr>
					<td>번호</td>
					<td>${data.board_no }</td>
				</tr>
				<tr>
					<td>제 목</td>
					<td><input name="title" type="text" size="70" maxlength="100"
						value="${data.board_title }" /></td>
				</tr>
				<tr>
					<td>내 용</td>
					<td><input name="title" type="text" size="70" maxlength="100"
						value="${data.board_content }" /></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><input name="title" type="text" size="70" maxlength="100"
						value="${data.board_writedate }" /></td>
				</tr>
				<tr align="center" valign="middle">
					<td colspan="5">  <input
						type="submit" value="글쓰기">  
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>