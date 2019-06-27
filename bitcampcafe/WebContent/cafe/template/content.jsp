<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.include_content {
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<div class="include_content">
		<c:set var="page" value="${param.page }"></c:set>
		<c:if test="${page!=null}">
			<jsp:include page="${page }"></jsp:include>
		</c:if>
		<c:if test="${page==null }">
			<jsp:include page="nopage.jsp"></jsp:include>
		</c:if>
	</div>
</body>
</html>