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
			<label for="content">내용</label> <input type="text" id="content"
				name="content"> <label for="place">장소</label> <input
				type="text" id="place" name="place"> <select name='color'>
				<option value='' selected>-- 색상 --</option>
				<option value='#ff6666' style='background-color: #ff6666'>시험</option>
				<option value='#66ff8c' style='background-color: #66ff8c'>공지</option>
				<option value='#66b3ff' style='background-color: #66b3ff'>과제</option>
				<option value='#ffff66' style='background-color: #ffff66'>스터디</option>
				<option value='#ffccff' style='background-color: #ffccff'>기타</option>
			</select> <label for="start">시작</label> <input type="date" id="start"
				name="start"> <label for="end">끝</label> <input type="date"
				id="end" name="end"> <input type="submit" value="추가하기">
	</form>
</body>
</html>