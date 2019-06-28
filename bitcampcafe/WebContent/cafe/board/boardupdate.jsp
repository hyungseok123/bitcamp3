<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:out value="${dto.member_nickname }"></c:out>
	<c:out value="${dto.board_writedate }"></c:out>
	<div>
		<form id="boardupdate" method="post" action="boardupdateresult.do">
			<textarea name="board_title" cols="100" rows="5">${dto.board_title }</textarea>
			<input type="text" name="board_content" value="${dto.board_content }">
			<input type="hidden" name="board_no" value="${dto.board_no }">
			<input id="submitbutton" type="submit" value="등록">
		</form>
	</div>
</body>
</html>