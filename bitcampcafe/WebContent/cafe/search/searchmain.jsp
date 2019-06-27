<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
</head>
<style>
	#searchmain{
		float: right;
	}
	#searchmainform{
		width: 100%;
		height: 35px;
	}
	
	#searchmaininput{
		width: 232px;
		height: 33px;
		padding: 0 6px;
		border: 1px solid silver;
		margin: 0;
		vertical-align: middle;
	}
	
	#searchmainsubmit{
		width: 56px;
		height: 35px;
		background-color: #03c75a;
		border: 0px;
		margin-left: -6px;
		color: white;
		vertical-align: middle;
	}
</style>
<body>
<div id="searchmain">
<form method="get" action="searchmain.do" id="searchmainform" name="searchmainform" >
	<input type="text" id="searchmaininput" name="searchinput">
	<input type="submit" value="검색" id="searchmainsubmit">
</form>
</div>
</body>
</html>