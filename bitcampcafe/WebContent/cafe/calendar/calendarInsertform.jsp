<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
	제목 title,  시작 start, 끝end   
	  -->
	<form method="post" action="calendarinsertresult.do">

		<label for="title">제목</label> <input type="text" id="title"
			name="title">


		<div class="col-xs-12">
			<label for="content">내용</label>
			 <input type="text" id="content"
				name="content"> 
				<label for="place">장소</label> <input
				type="text" id="place" name="place">
				 <label for="color">색상</label>
			<input type="text" id="color" name="color"> 
			<label
				for="start">시작</label>
				 <input type="text" id="start" name="start"
				placeholder="YYYY-MM-DD"> 
				<label for="end">끝</label> 
				<input
				type="text" id="end" name="end"> <input type="submit" value="추가하기">
	</form>
</body>
</html>