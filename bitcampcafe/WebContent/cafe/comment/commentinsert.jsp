<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment</title>
</head>
<body>
<div>
  <form method="post" action="commentinsert.do">
    <c:if test="${list != null }">
      <input type="hidden" name="board_no" value="${list[0].board_no }">
    </c:if>
    <textarea name="content" cols="100" rows="5"></textarea>
    <input type="submit" value="등록">
  </form>
</div>
</body>
</html>