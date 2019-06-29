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

 
<c:set var="totalpage" value="${requestScope.totalpage }" />
	<c:set var="startblock" value="${requestScope.startblock }" />
	<c:set var="endblock" value="${requestScope.endblock }" />
	<c:set var="blocksize" value="${requestScope.blocksize }" />
	<c:set var="currpage" value="${requestScope.currpage }" />
	<table>
		<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="20%">
			<col width="20%">
			<col width="10%">
		</colgroup>
		
		<tbody id="searchsubresult">
			<c:set var="list" value="${requestScope.list }" />
			<c:if test="${list eq null || list eq requestScope.null2 }">
				<tr>
					<td colspan="5">등록된 게시글이 없습니다.</td>
				<tr>
			</c:if>
			<c:if test="${list != null }">
				<c:forEach var="index" items="${list }">
					<tr class="tddefault">
						<td>${index.board_no }</td>
						<td><a href="boarddetail.do?no=${index.board_no }"
							class="detaillink">${index.board_title }</a></td>
						<td>${index.member_nickname }</td>
						<td>${index.board_writedate }</td>
						<td>${index.board_viewcount }</td>
					</tr>

				</c:forEach>
			</c:if>
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