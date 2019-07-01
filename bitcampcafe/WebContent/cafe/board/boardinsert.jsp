<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<title>Board</title>
<style>
#writeinsert {
	margin: 0 auto;
}

table, tr, td {
	border: 1px solid #03c75a;
	border-collapse: collapse;
	padding: 4px;
}

.btn {
	margin-top: 10px;
	width: 70px;
	height: 30px;
	border: 1px solid #03c75a;
	background-color: white;
	font-family: 'Cambria';
	border-radius: 10px;
}
</style>

</head>
<body>
	<form method="post" action="boardinsertresult.do">
		<input type="hidden" name="member_no" value="${memberInfo.member_no}">
		<input type="hidden" name="category_no" value="${param.cno }">
		<table width="100%" border="3" bordercolor="lightgray" align="center">
			<tr>
				<td id="title">카테고리</td>
				<td>${category_name }</td>
			</tr>
			<tr>
				<td id="title">작성자</td>
				<td>${memberInfo.member_nickname }</td>
			</tr>
			<!-- <tr>
				<td id="title">카테고리</td>
				<td><select name="selectBox" id="selectBox"
					style="width: 90px;" class="select_02">
				</select></td>
			</tr> -->
			<tr>
				<td id="title">제 목</td>
				<td><input name="board_title" type="text" size="70"
					maxlength="100" value="" required="required"
					style="background-color: transparent; border: 0 solid black;" /></td>
			</tr>
			<tr>
				<td colspan="5"><textarea name="board_content" cols="72" rows="50"
						required="required" id="summernote"
						style="background-color: transparent; border: 0 solid black;">
				</textarea></td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5"><input type="reset" value="작성취소" class="btn">
					<input type="submit" value="등록" class="btn"> <a
					href="boardlist.do"><input type="button" value="목록" class="btn"></a>
				</td>
			</tr>
		</table>
	</form>
	<script>
      $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 400
      });
    </script>
</body>
</html>