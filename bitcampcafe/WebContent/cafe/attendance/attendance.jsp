<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.mobtn{
text-decoration:none;
border:1px solid white;
background-color:#03c75a;
color:white;
border-radius:5px;

}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>


<div>

<table>
 
 <tbody>
 <c:forEach var="dto" items="${requestScope.list }">
 <tr>
   <td>${dto.member_nickname} </td>
   <td>${dto.attendance_no }</td>
   <td>${dto.attendance_content }</td>
   <td>${dto.attendance_writedate }</td>
   <td><a class="mobtn" href="attendanceupdate.do?no=${dto.attendance_no }">수정</a></td>
   <td><a class="mobtn" href="attendancedelete.do?no=${dto.attendance_no }">삭제</a></td>
 </tr>
 
 
 
 </c:forEach>
 
 </tbody>
</table>


</div>
</body>
</html>