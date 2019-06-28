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
	<c:out value="${memberInfo.member_nickname}"></c:out>

	<div>
		<form id="boardupdate" method="post" action="boardupdateresult.do">
			<input type="hidden" name="board_no"
				value="${dto.board_no }">
			<li><input type="text" name="board_title"
				value="${dto.board_title }"></li>
			<li><textarea name="board_content" cols="100" rows="5">${dto.board_content }</textarea>
			</li> <input type="submit" value="수정"> <input type="reset"
				value="취소">
		</form>
	</div>
</body>
</html>

