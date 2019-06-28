<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://localhost:8080/bitcampcafe/cafe/comment/tempcommentcss.css">
<title>Detail</title>
<style>
.detail_all_wrap {
	padding: 10px;
}
#board_detail_wrap {
	width: 840px;
}
.detail_ul li {
	border-bottom: 1px solid silver;
}
.detail_content {
	margin: 10px 0px;
	height: 500px;
}
.detail_comment_views {
	padding: 10px 0;
	border-bottom: 1px solid silver;
	margin-bottom: 10px;
}
.detail_subcontent_wrap {
	width: 100%;
	display: inline-block;
}
.detail_subcontent_left {
	float: left;
}
.detail_subcontent_right {
	float: right;
}
.detail_title {
	font-size: 20px;
}
</style>
</head>
<body>
<div class="detail_all_wrap">
  <div id="board_detail_wrap">
    <ul class="detail_ul">
      <li>
        <div class="detail_subcontent_wrap">
        <div class="detail_subcontent_left">
          <b class="detail_title"><c:out default="null" value="${dto.board_title }"></c:out></b>
		   |
		  <c:out default="null" value="${dto.category_name }"></c:out> 
        </div>
        <div class="detail_subcontent_right">
		  <c:out default="null" value="${dto.board_writedate }"></c:out>
        </div>
       </div>
      </li>
      <li class="detail_writer"> 
		<c:out default="null" value="${dto.member_nickname }"></c:out> 
      </li>
      <li class="detail_content">
		<c:out default="null" value="${dto.board_content }"></c:out> 
      </li>
    </ul>
  </div>
  <div class="detail_comment_views">
	댓글(<c:out default="null" value="${commentTotalCount }"></c:out>)
	 | 
	조회수(<c:out default="null" value="${dto.board_viewcount }"></c:out>)
  </div>
  <div class="load_comment"></div>
  
  <!--수정 삭제 만들기  -->
   <div class="board_update_button">
  <c:if test="${memberInfo.member_no eq dto.member_no}">
  <a href="boardupdate.do?no=${dto.board_no }">
   <button>수정</button></a>
   <a href="boarddelete.do?no=${dto.board_no }"><button>삭제</button></a>
 </c:if>
  </div>
  <!-- 여기까지 -->
  <span class="post_board_no">${dto.board_no }</span>
</div>
  <script>
 $('.post_board_no').hide();
	$.ajax({
	    url      : "commentlist.do",
	    type     : "GET",
		data     : "board_no="+ $('.post_board_no').text(),
	    dataType : "html",
	    success  : function(data) {
	        	       $('.load_comment').append(data);
	    		   },
	    error    : function(data) {
	    		       alert("error!!!!!!!!!!!!!!!!!");
	               }
	});
  </script>
</body>
</html>