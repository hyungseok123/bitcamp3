<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function send() {
		location.href="login.do";
	}
</script>
<style>
	*{
		margin: 0px;
		padding: 0px;
	}
	#start{
		width: 1920px;
		height: 980px;
		background-color: #03c75a;
		font-size: 200px;
		color: white;
	}
</style>
</head>
<body>
<button onclick="send()" id="start">Start !</button>
</body>
</html>