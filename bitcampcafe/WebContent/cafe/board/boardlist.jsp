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
a{
text-decoration: none;
color:black;
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
	
	<!-- 페이징  -->
	<c:set var="totalpage" value="${requestScope.totalpage }" />
	<c:set var="startblock" value="${requestScope.startblock }" />
	<c:set var="endblock" value="${requestScope.endblock }" />
	<c:set var="blocksize" value="${requestScope.blocksize }" />
	<c:set var="currpage" value="${requestScope.currpage }" />
	<table>
	
	<%-- 	<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="20%">
			<col width="20%">
			<col width="10%">
		</colgroup> --%>
		
		<tbody id="searchsubresult">
			<c:set var="list" value="${requestScope.list }" />
			<c:if test="${list eq null || list eq requestScope.null2 }">
				<tr>
					<td colspan="5">등록된 게시글이 없습니다.</td>
				<tr>
			</c:if>
			<c:if test="${list != null }">
				<%-- <c:forEach var="index" items="${list }"> --%>
					<c:if test="${startblock>1 }">
						<a href="main.do?currpage=${startblock-1 }">이전</a>
					</c:if>
					<c:forEach var="i" begin="${startblock }" end="${endblock }">
						<c:if test="${i==currpage }">
							<c:out value="${i }"></c:out>
						</c:if>
						<c:if test="${i!=currpage }">
							<a href="main.do?currpage=${i }"><c:out value="${i }"></c:out></a>
						</c:if>
					<%-- </c:forEach> --%>
					<c:if test="${endblock<totalpage }">
						<a href="main.do?currpage=${endblock+1 }">다음</a>
					</c:if>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</body>
</html>