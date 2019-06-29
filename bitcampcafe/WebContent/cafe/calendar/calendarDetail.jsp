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

.form-style-5 input[type="text"], .form-style-5 input[type="date"],
	.form-style-5 input[type="datetime"], .form-style-5 input[type="email"],
	.form-style-5 input[type="number"], .form-style-5 input[type="search"],
	.form-style-5 input[type="time"], .form-style-5 input[type="url"],
	.form-style-5 textarea, .form-style-5 select {
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
	color:  black;
	-webkit-box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	margin-bottom: 30px;
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
				<%=dto.getCalendar_no()%>
				<%=dto.getCalendar_title()%>
				<%=dto.getCalendar_start()%>
				<%=dto.getCalendar_end()%>
				<%=dto.getCalendar_content()%>
				<%=dto.getCalendar_place()%>
				<%=dto.getCalendar_color()%>
				<%=dto.getMember_nickname()%>
			
			<c:if test="${memberInfo.member_no eq dto.member_no }">
				<a href="calendardelete.do?no=<%=dto.getCalendar_no()%>"> <input
					type="button" value="삭제">
				</a>
				<a href="calendarmodify.do?no=<%=dto.getCalendar_no()%>"> <input
					type="button" value="수정">
				</a>
			</c:if>
			<a href="calendarlist.do"> <input type="button" value="달력">
			</a>
		</fieldset>
	</div>

	<%
		}
	%>

</body>
</html>