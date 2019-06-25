<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
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