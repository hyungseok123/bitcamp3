<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.list_main_img {
	width: 860px;
	height: 150px;
	border-bottom: 1px solid silver;
	margin-bottom: 30px;
}
.detail_all_wrap {
	padding: 0;
}
#board_detail_wrap {
	width: 860px;
}
.board_list_table {
	padding: 10px;
	width: 860px;
	border-top: 1px solid silver;
	border-collapse: collapse;
}
.board_list_tr {
	border-bottom: 1px solid silver;
}
.board_list_tr td {
	padding: 5px;
}
.board_list_table_btn a {
	position: relative;
	left: 110px;
}
.board_list_table_btn a button {
	margin-top: 10px;
	width: 70px;
	height: 30px;
}
</style>
</head>
<body>
  <div class="list_main_img"></div>
	<div class="detail_all_wrap">
		<table class="board_list_table">
		  <tbody>
			<c:forEach var="data" items="${requestScope.list }">
				<tr class="board_list_tr">
				  <td>${data.board_no }</td>
				  <td><a href="boarddetail.do?no=${data.board_no }"><c:out default="null" value="${data.board_title }"></c:out></a></td>
				  <td><c:out default="null" value="${data.member_nickname }"></c:out></td>
				  <td><c:out default="null" value="${data.board_writedate }"></c:out></td>
				  <td><c:out default="null" value="${data.board_viewcount }"></c:out></td>
				</tr>
			</c:forEach>
				<tr align="center" valign="baseline">
				  <td colspan="3">
				  </td>
				  <td class="board_list_table_btn" colspan="2"> 
					 <a href="boardinsert.do"><button>글쓰기</button></a>  
				  </td>
				</tr>
		  </tbody>
		</table>
	</div>
</body>
</html>