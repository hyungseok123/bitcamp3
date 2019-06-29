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
	background-image: url("img/anothermainimg.jpg");
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
.board_list_btn {
	margin-left: 780px;
}
.board_list_btn button {
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
		  </tbody>
		</table>
	  <c:if test="${param.cno != null }">
	    <a class="board_list_btn" href="boardinsert.do?cno=${param.cno }"><button>글쓰기</button></a>
	  </c:if>
	</div>
</body>
</html>