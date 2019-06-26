<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="">

	 

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
		 
		 
		
		<tr align="center" valign="middle">
			<td colspan="5">
				<input type="reset" value="작성취소" >
				<input type="submit" value="수정" >
				<input type="button" value="목록"  >			
			</td>
		</tr>
	</table>	
	</form>
	
</body>
</html>