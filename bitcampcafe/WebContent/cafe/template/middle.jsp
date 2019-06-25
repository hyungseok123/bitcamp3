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
	position:relative;
	left:494px;
	top:239px;
	
}

#content {
	background-color: green;
	width: 100%;
	height:620px;
	
    position:relative;
    left:690px;
    top:220px;
    


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