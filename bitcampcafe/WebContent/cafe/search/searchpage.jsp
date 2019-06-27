<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	#searchmainpage{
		width: 800px;
		min-height: 620px;
	}
	
	#searchsubbox{
		width: 100%;
		height: 36px;
		padding: 16px 0;
		background-color: #f9f9f8;
		text-align: center;
	}
	
	#searchsubbox select{
		width: 142px;
		height: 34px;
		padding: 7px 36px 7px 12px;
		vertical-align: middle;
	}
	
	#searchsubinput{
		width: 232px;
		height: 32px;
		padding: 0 6px;
		border: 1px solid silver;
		margin: 0;
		vertical-align: middle;
	}
	
	#searchsubsubmit{ 
		width: 56px;
		height: 34px;
		background-color: #03c75a;
		border: 0px;
		margin-left: -6px;
		color: white;
		vertical-align: middle;
	}
	#searchtable table{
		border-top: 1px solid black;
		font-size: 13px;
	}
	
	#searchtable th {
		height: 40px;
		padding: 2px;
		border-bottom: 1px solid silver;
	}
	
	#searchtable td {
		padding: 4px 18px 4px 12px;
		height: 28px;
		text-align: center;
		border-bottom: 1px solid silver;
	}
	
	#searchmainpage a {
		text-decoration: none;
	}
	
	#searchmainpage a:hover {
		text-decoration: underline;
	}
</style>
<body>
<section id="searchmainpage">
	<div id="searchsubbox">
		<form method="get" action="searchmain.do" id="searchsubform" name="searchsubform" >
			<select name="searchselect1">
				<option value="전체게시판">전체게시판</option>
				<option value="게시판추가">게시판추가</option>
			</select>
			<select name="searchselect2">
				<option value="제목+내용">제목+내용</option>
				<option value="제목만">제목만</option>
				<option value="작성자">작성자</option>
			</select>
			<input type="text" id="searchsubinput" name="searchinput" value="${requestScope.searchtext }">
			<input type="submit" value="검색" id="searchsubsubmit">
		</form>
	</div>
	<div id="searchtable">
		<table>
			<colgroup>
				<col width="10%">
				<col width="50%">
				<col width="10%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr><th> </th><th>제목</th><th>작성자</th><th>작성일</th><th>조회<th></tr>
			</thead>
			<tbody id="searchsubresult">
				<c:set var="list" value="${requestScope.list }"/>
					<c:if test="${list == null }">
						<tr><td colspan="5">등록된 게시글이 없습니다.</td><tr>
					</c:if>
					<c:if test="${list != null }">
						<c:forEach var="index" items="${list }">
							<tr>
								<td>${index.board_no }</td>
								<td><a href="boarddetail.do?no=${index.board_no }">${index.board_title }</a></td>
								<td>${index.member_nickname }</td>
								<td>${index.board_writedate }</td>
								<td>${index.board_viewcount }</td>
							</tr>
						</c:forEach>
					</c:if>
			</tbody>
		</table>
	</div>
</section>
</body>
</html>