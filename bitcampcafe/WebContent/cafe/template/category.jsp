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
		padding-bottom: 80px;
	}
	ul.category_list {
		padding: 10px;
		border-bottom: 1px dotted silver;
	}
	ul li {
		list-style: none;
	}
</style>
</head>
<body>
  <div class="aside_category">
    <ul class="category_list">
      <li><h3>카테고리</h3></li>
    </ul>
    <ul class="category_list">
  	  <li><a href="#">java 수업자료</a></li>
  	  <li><a href="#">html_css수업자료</a></li>
    </ul>
    <ul class="category_list">
  	  <li><a href="#">java 과제</a></li>
      <li><a href="#">html_css과제</a></li>
    </ul>
    <ul class="category_list">
  	  <li><a href="#">자유게시판</a></li>
    </ul>
  </div>
</body>
</html>