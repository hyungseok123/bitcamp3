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
		CalendarDTO dto = (CalendarDTO) request.getAttribute("dto");
		if (dto == null) {
	%>
	<%="자료없뜸"%>
	<%
		} else {
	%>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>시작</th>
				<th>끝</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=dto.getCalendar_no()%></td>
				<td><%=dto.getCalendar_title()%></td>
				<td><%=dto.getCalendar_start()%></td>
				<td><%=dto.getCalendar_end()%></td>
				<td><%=dto.getCalendar_content()%></td>
				<td><%=dto.getCalendar_place()%></td>
				<td><%=dto.getCalendar_color()%></td>

			</tr>
		</tbody>
	</table>
	<%
		}
	%>
	<a href="delete.do?no=<%=dto.getCalendar_no()%>"> <input
		type="button" value="삭제">
	</a>
	<a href="modify.do?no=<%=dto.getCalendar_no()%>"> <input
		type="button" value="수정">
	</a>
	<a href="calendarMain.jsp"> <input type="button" value="달력">
	</a>
</body>
</html>