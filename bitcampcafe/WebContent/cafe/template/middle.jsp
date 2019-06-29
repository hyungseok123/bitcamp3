<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mid{
	height: auto;
	width: 100%;
}
#aside {
	float: left;
	width: 200px;
}
#content {
	float: right;
	width: 860px;
	height: auto;
	padding-bottom: 30px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div id="mid">
	<div id="aside">
		<jsp:include page="aside.jsp"></jsp:include>
	</div>
	<div id="content">
		<jsp:include page="content.jsp"></jsp:include>
	</div>
	</div>
</body>
</html>