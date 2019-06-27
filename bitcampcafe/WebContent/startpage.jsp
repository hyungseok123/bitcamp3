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
		location.href="login.do"
	}
</script>
<style>
	#start{
		width: 1000px;
		height: 1000px;
		background-color: #03c75a;
		font-size: 100px;
	}
</style>
</head>
<body>
<button value="시작" onclick="send()" id="start">시작</button>
</body>
</html>