<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
<tr><th>출석체크 수정하기</th></tr>

</thead>

</table>
<form id="frm" method = "post"  action="attendanceupdateresultaction.do">
	<input type="hidden" name="attendance_no" value="${attendance_no }">
	<textarea name="attendance_content" cols="90" rows="8">${content }</textarea>
    <input type="submit" value="수정하기" >
    <input type="reset" value="다시쓰기">
</form>
</body>
</html>