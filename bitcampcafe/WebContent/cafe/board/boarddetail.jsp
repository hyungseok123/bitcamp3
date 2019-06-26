<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="data" value="${requestScope.data}" />
</head>


<body>
	<table >
		<tr>
			<td>번호</td>
			<td id="boardno"><c:out value="${data.getBoardNo() }" /></td>		</tr>
		<tr>
			<td>제목</td>
			<td><c:out value="${data.getBoardTitle() }" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><c:out value="${data.getBoardContent() }" /></td>
		</tr>

	</table>
	<form method="post" action=" "
		name="frm">
		<textarea rows="5" cols="50" name="content" id="content"></textarea>
		<br> <input type="text" id="writer" name="writer"> <input
			type="button" onclick='send()' value="추가">
	</form>
	<div id="result"></div>
</body>
</html>