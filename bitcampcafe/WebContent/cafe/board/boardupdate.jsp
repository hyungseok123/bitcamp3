<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<div>
		<form id="boardupdate" method="post" action="boardupdateresult.do">

			<input type="hidden" name="board_no" value="${dto.board_no }">

			<table width="100%" border="3" bordercolor="lightgray" align="center">

				<tr>
					<td id="title">작성자</td>
					<td>${memberInfo.member_nickname }</td>
				</tr>
				<td id="board_title">제 목</td>
				<td><input type="text" name="board_title"
					value="${dto.board_title }" style="background-color:transparent;border:0 solid black;"></td>
				</tr>

				<tr>
					<td id="title">내 용</td>
					<td><textarea name="board_content" cols="72" rows="20" style="background-color:transparent;border:0 solid black;">${dto.board_content }</textarea></td>
				</tr>
				<tr align="center" valign="middle">
					<td colspan="5"><input type="reset" value="작성취소"> <input
						type="submit" value="수정"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>

