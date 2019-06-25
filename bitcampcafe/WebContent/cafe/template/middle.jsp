<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mid{
width: 800px;
}
#aside {
	float: left;
	background-color: white;
	width: 20%;
	height: 100px;
}

#content {
	background-color: green;
	width: 70%;
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