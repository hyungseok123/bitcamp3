<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action=" " name="boardForm" 
			enctype="multipart/form-data">

	 

	<table >
		<tr>
			<td id="title">작성자</td>
			<td>${board.board_id}</td>
		</tr>
			<tr>
			<td id="title">
				제 목
			</td>
			<td>
				<input name="board_subject" type="text" size="70" maxlength="100" 
					value="${board.board_subject}"/>
			</td>		
		</tr>
		<tr>
			<td id="title">
				내 용
			</td>
			<td>
				<textarea name="board_content" cols="72" rows="20">
					${board.board_content}
				</textarea>			
			</td>		
		</tr>
				<!-- 답글이 아닐 경우에만 파일 첨부 가능하도록 처리 -->
		 
		
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