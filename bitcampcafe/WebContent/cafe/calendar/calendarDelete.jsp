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
		int result = (Integer) request.getAttribute("result");
		if (result > 0) {
	%>

	<script type="text/javascript">		
		location.href = "calendarlist.do";
	</script>
	<%
		}
	%>
</body>
</html>