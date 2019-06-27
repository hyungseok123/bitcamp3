<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<style>
.a{
	margin-bottom: 10px;
	width: 100%;
	height: 150px;
	border: 1px solid silver;
}
.search_wrap {
	width: 100%;
	height: 45px;
}
</style>
</head>
<body>
<div class="a">헤더입니다.</div>
<div class="search_wrap">
	<jsp:include page="/cafe/search/searchmain.jsp"></jsp:include>
</div>
</body>
</html>