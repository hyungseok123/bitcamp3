<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
 	$('form').on('submit',function(event){
		var searchsubinput = $('#searchsubinput').val();
		if(searchsubinput == null || searchsubinput =="") {
			event.preventDefault();
			alert('검색어를 입력하세요').one();
		}
		else {
			$('form').submit();
		}			
	});
		
	$(document).ready(function() {
		$('.trsearchselect3').hide();
		var searchselect1 = '<%=request.getAttribute("searchselect1")%>'
		var searchselect2 = '<%=request.getAttribute("searchselect2")%>'
		var searchselect3 = '<%=request.getAttribute("searchselect3")%>'
		<%
		Object obj = request.getAttribute("searchselect3");
		String searchselect3 = "";
		if(obj == null) {
			searchselect3 = "제목만 보기";
		}
		else {
			searchselect3 = "제목 and 내용보기";
		}
		%>
		if(searchselect1 != null ) {
			$('#searchselect1').val(searchselect1);
		}
		else {
			$('#searchselect1').val('전체게시판');
		}
	
		if(searchselect2 != null) {
			$('#searchselect2').val(searchselect2);
		} 
		else{
			$('#searchselect2').val('제목+내용');
		}
	
		if(searchselect3 == '제목 and 내용보기') {
			$('#searchselect3').val(searchselect3);
			$('.trsearchselect3').show();
		}
		else{
			$('#searchselect3').val('제목만 보기');
			$('.trsearchselect3').hide();
		}
		
 		$('#searchselect3').on('click',function(){
 			var searchselect3 = $('#searchselect3').val();
 			if(searchselect3 == "제목만 보기") {
 				$('.trsearchselect3').hide();
 				<% searchselect3 = "제목만 보기"; %>
 			}
 			else {
 				$('.trsearchselect3').show();
 				<% searchselect3 = "제목 and 내용보기"; %>
 			}
 		});
	});
</script>
<style>
	#searchmainpage{
		width: 860px;
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
		width: 162px;
		height: 34px;
		padding: 7px 16px 7px 12px;
		vertical-align: middle;
	}
	
	#searchselect3 {
		background-color: #f9f9f8;
		color: #03c75a;
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
		border-bottom: 1px solid silver;
		font-size: 13px;
	}
	
	#searchtable th {
		height: 40px;
		padding: 2px;
	}
	
	.tddefault td {
		padding: 4px 18px 4px 12px;
		height: 28px;
		color: black;
		border-top: 1px solid silver;
		text-align: center;
	}
	
	.trsearchselect3 {
		color: silver;
		text-align: center;
	}
	
	#searchmainpage a {
		text-decoration: none;
	}
	
	#searchmainpage a:hover {
		text-decoration: underline;
	}
	
	#searchpaging {
		width: 100%;
		height: 40px;
		padding-top: 16px;
		margin-top: 32px;
		background-color: #f9f9f8;
		text-align: center;
	}
	
	.pagingbox{
		width: 24px;
		height: 24px;
		background-color: white;
		border: 1px solid silver;
		text-align: center;
		vertical-align: middle;
		color: #03c75a;
		text-decoration: none;
		display: inline-block;
	}
	
	.pagingboxatag{
		color: black;
	}
	
	.pagingboxatag:hover {
		text-decoration: underline;
		color: #03c75a;
	}
	
	.pagingboxatag:visited {
		color: black;
	}
	
	.detaillink {
		color: black;
	}
	
	.searchimport {
		color: #03c75a;
	}
	
	.trsearchselect3 a{
		color: gray;
	}
	
</style>
<body>
<c:set var="totalpage" value="${requestScope.totalpage }"/>
<c:set var="startblock" value="${requestScope.startblock }"/>
<c:set var="endblock" value="${requestScope.endblock }"/>
<c:set var="blocksize" value="${requestScope.blocksize }"/>
<c:set var="currpage" value="${requestScope.currpage }"/>
<c:set var="searchselect1" value="${requestScope.searchselect1 }"/>
<c:set var="searchselect2" value="${requestScope.searchselect2 }"/>
<section id="searchmainpage">
	<div id="searchsubbox">
		<form method="get" action="searchmain.do" id="searchsubform" name="searchsubform" >
			<select name="searchselect1" id="searchselect1">
				<option value="전체게시판">전체게시판</option>
				<option value="java 수업자료">java 수업자료</option>
				<option value="html_css수업자료">html_css수업자료</option>
				<option value="java 과제">java 과제</option>
				<option value="htmlcss과제">htmlcss과제</option>
				<option value="자유게시판">자유게시판</option>
			</select>
			<select name="searchselect2" id="searchselect2">
				<option value="제목+내용">제목+내용</option>
				<option value="제목만">제목만</option>
				<option value="작성자">작성자</option>
			</select>
			<c:set var="searchinput" value="${requestScope.searchtext }"/>
			<input type="text" id="searchsubinput" name="searchinput" value="${searchinput }">
			<input type="submit" value="검색" id="searchsubsubmit">
			<select name="searchselect3" id="searchselect3">
				<option value="제목만 보기">제목만 보기</option>
				<option value="제목 and 내용보기">제목 and 내용보기</option>
			</select>
		</form>
	</div>
	<div id="searchtable">
		<table>
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="20%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr><th> </th><th>제목</th><th>작성자</th><th>작성일</th><th>조회<th></tr>
			</thead>
			<tbody id="searchsubresult">
				<c:set var="list" value="${requestScope.list }"/>
					<c:if test="${list eq null || list eq requestScope.null2 }">
						<tr><td colspan="5">등록된 게시글이 없습니다.</td><tr>
					</c:if>
					<c:if test="${list != null }">
						<c:forEach var="index" items="${list }">
							<tr class="tddefault">
								<td>${index.board_no }</td>
								<td><a href="boarddetail.do?no=${index.board_no }" class="detaillink">${index.board_title }</a></td>
								<td>${index.member_nickname }</td>
								<td>${index.board_writedate }</td>
								<td>${index.board_viewcount }</td>
							</tr>
							<tr class="trsearchselect3">
								<td></td>
								<td><a href="boarddetail.do?no=${index.board_no }" class="detaillink">${index.board_content }</a></td>
								<td></td><td></td><td></td>
							</tr>
						</c:forEach>
					</c:if>
			</tbody>
		</table>
	</div>
	<div id="searchpaging">
		<c:if test="${currpage > blocksize }">
			<div class="pagingbox"><a class="pagingboxatag" href="searchmain.do?currpage=${currpage-1 }&searchinput=${searchinput }&searchselect1=${searchselect1 }&searchselect2=${searchselect2}&searchselect3=<%=searchselect3%>"> &lt;&lt; </a></div>
		</c:if>
		<c:forEach begin="${startblock }" end="${endblock }" varStatus="i">
			<c:if test="${i.index == currpage }">
				<div class="pagingbox"><c:out value="${currpage }"/></div>
			</c:if>
			<c:if test="${i.index != currpage }">
				<div class="pagingbox"><a class="pagingboxatag" href="searchmain.do?currpage=${i.index }&searchinput=${searchinput }&searchselect1=${searchselect1 }&searchselect2=${searchselect2}&searchselect3=<%=searchselect3%>">${i.index }</a></div>
			</c:if>
		</c:forEach>
		<c:set var="endblockmin" value="${((totalpage/blocksize)-(totalpage/blocksize%1))*blocksize+1 }"/> <!-- 마지막블럭 내림계산 -->
		<c:set var="endblockmax" value="${((totalpage/blocksize)+(1-((totalpage/blocksize)%1))%1)*blocksize }"/> <!-- 마지막블럭 올림계산 -->
		<c:if test="${!(currpage >= endblockmin && currpage <= endblockmax) && endblock != 0 }">
			<div class="pagingbox"><a class="pagingboxatag" href="searchmain.do?currpage=${endblock+1 }&searchinput=${searchinput }&searchselect1=${searchselect1 }&searchselect2=${searchselect2}&searchselect3=<%=searchselect3%>"> &gt;&gt; </a></div>
		</c:if>
	</div>
</section>
</body>
</html>