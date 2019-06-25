<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="currpage" value="${requestScope.currpage }"></c:set>
	<c:set var="startblock" value="${requestScope.startblock }"></c:set>
	<c:set var="endblock" value="${requestScope.endblock }"></c:set>
	<c:set var="list" value="${requestScope.list }"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage }"></c:set>

	<table>

		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="board" items="${list }">
				<tr>
					<td>${board.board_no}</td>
					<td>${board.board_title }</td>
					<td>${board.board_content }</td>
					<td>${board.board_writedate}</td>


				</tr>


			</c:forEach>


		</tbody>



	</table>

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

	</c:forEach>

	<c:if test="${endblock<totalpage }">
		<a href="main.do?currpage=${endblock+1 }">다음</a>
	</c:if>
</body>
</html>