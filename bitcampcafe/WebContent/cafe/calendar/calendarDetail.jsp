<%@page import="com.bitcafe.DTO.CalendarDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.form-style-5 {
	max-width: 500px;
	padding: 10px 20px;
	background: #f4f7f8;
	margin: 10px auto;
	padding: 20px;
	background: #f4f7f8;
	border-radius: 8px;
	font-family: 'Cambria';
}

.form-style-5 fieldset {
	border: none;
}

.form-style-5 legend {
	font-size: 1.4em;
	margin-bottom: 10px;
}

.form-style-5 label {
	display: block;
	margin-bottom: 8px;
}

th,td {
	font-family: 'Cambria';
	background: rgba(255, 255, 255, .1);
	border: none;
	border-radius: 4px;
	font-size: 15px;
	margin: 0;
	outline: 0;
	padding: 10px;
	width: 500px;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	background-color: #e8eeef;
	color: black;
	-webkit-box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	margin-bottom: 30px;
}

th{
background-color: #03c75a;
width: 300px;
color:white;
}

.form-style-5 input[type="text"]:focus, .form-style-5 input[type="date"]:focus,
	.form-style-5 input[type="datetime"]:focus, .form-style-5 input[type="email"]:focus,
	.form-style-5 input[type="number"]:focus, .form-style-5 input[type="search"]:focus,
	.form-style-5 input[type="time"]:focus, .form-style-5 input[type="url"]:focus,
	.form-style-5 textarea:focus, .form-style-5 select:focus {
	background: #b9c6b9;
}

.form-style-5 select {
	-webkit-appearance: menulist-button;
	height: 35px;
}

.form-style-5 .number {
	background: #03c75a;
	color: #fff;
	height: 30px;
	width: 30px;
	display: inline-block;
	font-size: 0.8em;
	margin-right: 4px;
	line-height: 30px;
	text-align: center;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.2);
	border-radius: 15px 15px 15px 0px;
}

.btn{
width: 80px;
height: 50px;
border-radius:10px;
background-color:#03c75a;
font-family: 'Cambria';
font-size: 15px;
}
</style>
</head>
<body>
	<%
		CalendarDTO dto = (CalendarDTO) request.getAttribute("dto");
		if (dto == null) {
	%>
	<%="자료없뜸"%>
	<%
		} else {
	%>
	<div class="form-style-5">
		<fieldset>
			<legend>
				<span class="number"></span> 일정
			</legend>


			<table>

				<tr>
					<th>일정 번호</th>
					<td><%=dto.getCalendar_no()%></td>
				</tr>

				<tr>
					<th>일정 제목</th>
					<td><%=dto.getCalendar_title()%></td>
				</tr>

				<tr>
					<th>일정 시작</th>
					<td><%=dto.getCalendar_start()%></td>
				</tr>

				<tr>
					<th>일정 끝</th>
					<td><%=dto.getCalendar_end()%></td>
				</tr>

				<tr>
					<th>일정 내용</th>
					<td><%=dto.getCalendar_content()%></td>
				</tr>

				<tr>
					<th>일정 장소</th>
					<td><%=dto.getCalendar_place()%></td>
				</tr>

				<tr>
					<th>작성자</th>
					<td><%=dto.getMember_nickname()%></td>
				</tr>
			</table>

			<!-- 그 일정의 작성자만 수정,삭제 가능, 작성자가 아니라면 조회만 가능 -->
			<c:if test="${memberInfo.member_no eq dto.member_no }">
				<a href="calendardelete.do?no=<%=dto.getCalendar_no()%>"> <input
					type="button" class="btn" value="삭제">
				</a>
				<a href="calendarmodify.do?no=<%=dto.getCalendar_no()%>"> <input
					type="button" class="btn" value="수정">
				</a>
			</c:if>
			<a href="calendarlist.do"> <input type="button" class="btn" value="달력">
			</a>
		</fieldset>
	</div>

	<%
		}
	%>

</body>
</html>