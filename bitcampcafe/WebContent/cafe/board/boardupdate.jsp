<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
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
		  <tr>
		  	<td id="board_title">제 목</td>
			<td><input type="text" name="board_title"
				value="${dto.board_title }" style="background-color:transparent;border:0 solid black;"></td>
		  </tr>
		  <tr>
			<td colspan="5">
			<textarea name="board_content" id="summernote" cols="72" rows="20" style="background-color:transparent;border:0 solid black;">
			${dto.board_content }</textarea></td>
		  </tr>
		  <tr align="center" valign="middle">
			<td colspan="5"><input type="reset" value="작성취소"> <input
				type="submit" value="수정"></td>
		  </tr>
		</table>
	</form>
  </div>
	<script>
      $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 400
      });
    </script>
</body>
</html>

