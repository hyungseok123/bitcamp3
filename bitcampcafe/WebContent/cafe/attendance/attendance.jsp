<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>


<div>

<table>
 <thead>
 <tr><th>내용</th></tr>
 </thead>
 
 <tbody>
 <c:forEach var="dto" items="${requestScope.list }">
 
 <tr><td>${dto.member_no } </td></tr>
 <tr><td>${dto.attendance_no }</td></tr>
 <tr><td>${dto.attendance_content }</td></tr>
 <tr><td>${dto.attendance_writedate }</td></tr>
 </c:forEach>
 <a href="attendanceupdate.do">수정하기</a>
<a href="attendancedelete.do">삭제하기</a>
 
 </tbody>
 


</div>
</body>
</html>