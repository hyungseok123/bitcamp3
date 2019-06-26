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

<form method="post" action="boarddetail.do" name="boardForm">

	 

	<table >
		<tr>
			<td>작성자</td>
			<td>${board.member_no}</td>
		</tr>
			<tr>
			<td>
				제 목
			</td>
			<td>
				<input name="board_title" type="text" size="70" maxlength="100" 
					value="${board.board_title}"/>
			</td>		
		</tr>
		<tr>
			<td>
				내 용
			</td>
			<td>
				<textarea name="board_content" cols="72" rows="20">
					${board.board_content}
				</textarea>			
			</td>		
		</tr>
		 
		 
	 
	</table>	
	</form>
	


</html>