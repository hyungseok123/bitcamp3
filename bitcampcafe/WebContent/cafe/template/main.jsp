<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	margin:0;
	padding:0;
}
#main_wrap {
	position: relative;
	width: 1080px;
	margin: 0 auto;
	clear: both;
}
</style>
</head>
<body>
<div id="main_wrap">
  <jsp:include page="tapnav.jsp"></jsp:include>
  <jsp:include page="header.jsp"></jsp:include>
  <jsp:include page="middle.jsp"></jsp:include>
  <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>