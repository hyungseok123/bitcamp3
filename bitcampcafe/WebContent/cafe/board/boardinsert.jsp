<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8088/bitcampcafe/css/cafe.css" />
 
</head>
<body>
	<form method="post" action="boardinsertresult.do">
		<ul>
			<li><label for="title">제목</label> <input type="text" id="title"
				name="title"></li>
			<li><label for="content">내용</label></li>
			<li><textarea rows="4" cols="50" id="content" name="content"></textarea>
			</li>

 
			<li><input type="submit" value="전송"> <input type="reset"
				value="취소"></li>
		</ul>
	</form>




</body>
</html>