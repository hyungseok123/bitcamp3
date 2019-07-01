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

board_detail_wrap {
	width: 860px;
}

.board_list_table {
	padding: 10px;
	width: 860px;
	border-top: 1px solid black;
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
	border: 1px solid #03c75a;
	background-color: white;
	font-family: 'Cambria';
	border-radius: 10px;
}

.board_list_btn button:hover{
background-color: #03c75a;
}

a {
	text-decoration: none;
	color: black;
}

.pagetitle {
	text-align: left;
	color: #03c75a;
}

.pagetitle th {
	border-bottom: 1px solid black;
	padding: 5px 0;
}

#pageboard {
	width: 100%;
	height: 40px;
	padding-top: 16px;
	margin-top: 32px;
	background-color: #f9f9f8;
	text-align: center;
}

.pagingbox {
	width: 24px;
	height: 24px;
	background-color: white;
	border: 1px solid silver;
	text-align: center;
	vertical-align: middle;
	color: #03c75a;
	text-decoration: none;
	display: inline-block;
}
</style>
</head>
<body>
	<div class="list_main_img"></div>
	<div class="detail_all_wrap">
		<table class="board_list_table">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="20%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr class="pagetitle">
					<th></th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회
					<th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="data" items="${requestScope.pagelist }">
					<tr class="board_list_tr">
						<td>${data.board_no }</td>
						<td><a href="boarddetail.do?no=${data.board_no }"><c:out
									default="null" value="${data.board_title }"></c:out></a></td>
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

	<!-- 페이징  -->

	<c:set var="totalpage" value="${requestScope.totalpage }" />
	<c:set var="startblock" value="${requestScope.startblock }" />
	<c:set var="endblock" value="${requestScope.endblock }" />
	<c:set var="blocksize" value="${requestScope.blocksize }" />
	<c:set var="currpage" value="${requestScope.currpage }" />

	<div id="pageboard">
		<c:if test="${pagelist != null }">
			<c:if test="${startblock > 1 }">
				<div class="pagingbox">
					<a href="boardlist.do?currpage=${startblock-1 }&cno=${param.cno }">◀</a>
				</div>
			</c:if>
			<c:forEach var="i" begin="${startblock }" end="${endblock }">
				<c:if test="${i==currpage }">
					<c:out value="${i }"></c:out>
				</c:if>
				<c:if test="${i!=currpage }">
					<div class="pagingbox">
						<a href="boardlist.do?currpage=${i }&cno=${param.cno }"><c:out
								value="${i }"></c:out></a>
					</div>
				</c:if>
			</c:forEach>
			<c:if test="${endblock < totalpage }">
				<div class="pagingbox">
					<a href="boardlist.do?currpage=${endblock+1 }&cno=${param.cno }">▶</a>
				</div>
			</c:if>
		</c:if>
	</div>
</body>
</html>