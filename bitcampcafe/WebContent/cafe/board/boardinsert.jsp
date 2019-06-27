<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8088/bitcampcafe/css/cafe.css" />
</head>
<body>

	<b><font size="6" color="gray">글쓰기</font></b>
	<br>

	<form method="post" action="boardinsertresult.do" name="boardInsert">
	
		<input type="hidden" name="member_nickname"
			value="${sessionScope.sessionID}">
		<table width="700" border="3" bordercolor="lightgray" align="center">
			<tr>
				<td id="title">작성자</td>
				<td>${sessionScope.sessionID}</td>
			</tr>
			<tr>
				<td id="title">제 목</td>
				<td><input name="board_title" type="text" size="70"
					maxlength="100" value="" required="required" /></td>
			</tr>
			<tr>
				<td id="title">내 용</td>
				<td><textarea name="board_content" cols="72" rows="20"
						required="required"></textarea></td>
			</tr>

			<tr align="center" valign="middle">
				<td colspan="5"><input type="reset" value="작성취소"> 
				<input type="submit" value="등록"> 
				 
					<input type="button" value="목록">
				</td>
			</tr>
		</table>
	</form>


</body>
</html>