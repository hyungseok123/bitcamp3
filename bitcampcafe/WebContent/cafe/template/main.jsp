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
.top_nav {
	height: 35px;
	border: 1px solid silver;
	margin-bottom: 10px;
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
  <div class="top_nav">
  <h2>NAVER</h2>
  </div>
  <jsp:include page ="header.jsp"></jsp:include>
  <jsp:include page ="middle.jsp"></jsp:include>
  <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>