<%@page import="com.bitcafe.DTO.CalendarDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		CalendarDTO dto = (CalendarDTO) request.getAttribute("dto");
	%>
	<form method="post" action="calendarmodifyresult.do">
		<table>
			<thead>
				<tr>
					<th><label for="no">번호</label></th>
					<th><label for="title">제목</label></th>
					<th><label for="start">시작</label></th>
					<th><label for="end">끝</label></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" id="no" name="no"
						value="<%=dto.getCalendar_no()%>" readonly="readonly"></td>
					<td><input type="text" id="title" name="title"
						value="<%=dto.getCalendar_title()%>"></td>
					<td><input type="text" id="start" name="start"
						value="<%=dto.getCalendar_start()%>"></td>
					<td><input type="text" id="end" name="end"
						value="<%=dto.getCalendar_end()%>"></td>
					<td><input type="text" id="content" name="content"
						value="<%=dto.getCalendar_content()%>"></td>
					<td><input type="text" id="place" name="place"
						value="<%=dto.getCalendar_place()%>"></td>
					<td><input type="text" id="color" name="color"
						value="<%=dto.getCalendar_color()%>"></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="수정"> <input type="reset"
			value="취소">
	</form>
</body>
</html>