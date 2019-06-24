<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8088/bitcampcafe/css/cafe.css"/>
<link rel="stylesheet" href="http://localhost:8088/bitcampcafe/css/skin.css"/>
</head>
<body>
<div>
  <form method="post" action="commentinsertaction.do">
    <textarea cols="100" rows="5">test</textarea>
    <input type="submit" value="등록">
  </form>
</div>
</body>
</html>