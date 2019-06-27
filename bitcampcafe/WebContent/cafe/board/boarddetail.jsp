<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="data" value="${requestScope.data}" />
</head>
<body>
<div id="board_detail_wrap">
    <ul>
      <li>
        <c:out default="null" value="${dto.board_title }"></c:out>
		<c:out default="null" value="${dto.category_name }"></c:out>     
		<c:out default="null" value="${dto.board_writedate }"></c:out> 
      </li>
      <li> 
		<c:out default="null" value="${dto.member_nickname }"></c:out> 
      </li>
      <li>
		<c:out default="null" value="${dto.board_content }"></c:out> 
      </li>
    </ul>
  </div>
  <div>
	<c:set var="page" value="${param.comment }"></c:set>
	<c:if test="${comment!=null}">
		<jsp:include page="${comment }"></jsp:include>
	</c:if>
	<c:if test="${comment==null }">
		<jsp:include page="/cafe/template/nopage.jsp"></jsp:include>
	</c:if>
  </div>
</body>
</html>