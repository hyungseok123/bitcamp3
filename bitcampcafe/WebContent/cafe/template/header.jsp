<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<style>
.main_link a {
	text-decoration: none;
	color: black;
	font-size: 2em;
	font-family: 'Cambria';
	font-weight: bold;
	width: 100%;
	height: 100%;
}

.a {
	padding: 10px;
	margin-bottom: 10px;
	width: 1058px;
	height: 180px;
	border: 1px solid silver;
	background-image: url("img/mainimg2.jpg");
}

.search_wrap {
	width: 100%;
	height: 45px;
}
</style>
</head>
<body>
	<div class="a">
		<h1 class="main_link">
			<a href="boardlist.do">BITCAMP CAFE</a>
		</h1>
	</div>
	<div class="search_wrap">
		<jsp:include page="/cafe/search/searchmain.jsp"></jsp:include>
	</div>
</body>
</html>