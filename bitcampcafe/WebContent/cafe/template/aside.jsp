<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#information {
	border: 1px solid silver;
	height: 20%;
	margin-bottom: 5%
}
#category {
	border: 1px solid silver;
	height: 75%;
		margin-bottom: 10px;
}
</style>
</head>
<body>
	<div id="information">
		<jsp:include page="information.jsp"></jsp:include>
	</div>
	<div id="category">
		<jsp:include page="category.jsp"></jsp:include>
	</div>
</body>
</html>