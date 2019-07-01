<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.aside_category {
		padding-bottom: 40px;
		border-bottom: 3px solid #03c75a;
	}
	ul.category_list {
		padding: 10px;
		border-bottom: 1px dotted silver;
	}
	ul li {
		list-style: none;
	}
	.aside_category a {
		color: black;
		text-decoration: none;
	}
	
	.aside_category a:hover {
		color: 	#03c75a;
		text-decoration: underline;
	}
	
	.aside_category li {
		margin: 5px 0;
	}
	#aside_categoryh3 {
		font-size: 1.17em;
		font-weight: bold;
	}
	
	ul{
		margin-bottom: 0;
	}
</style>
</head>
<body>
  <div class="aside_category">
    <ul class="category_list">
      <li><h3 id="aside_categoryh3">카테고리</h3></li>
    </ul>
    <ul class="category_list">
  	  <li><a href="boardlist.do">전체보기</a></li>
  	  <li><a href="calendarlist.do">카페 캘린더</a></li>
  	   <li><a href="attendanceinsert.do">출석체크</a></li>
    </ul>
    <ul class="category_list">
  	  <li><a href="boardlist.do?cno=1">java 수업자료</a></li>
  	  <li><a href="boardlist.do?cno=2">html_css수업자료</a></li>
    </ul>
    <ul class="category_list">
  	  <li><a href="boardlist.do?cno=3">java 과제</a></li>
      <li><a href="boardlist.do?cno=4">html_css과제</a></li>
    </ul>
    <ul class="category_list">
  	  <li><a href="boardlist.do?cno=5">자유게시판</a></li>
    </ul>
  </div>
</body>
</html>