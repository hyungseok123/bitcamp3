<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.navericon {
	text-decoration:none;
	color: #03c75a;
}

.top_nav {
	width: 1078px;
	height: 35px;
	margin-bottom: 10px;
	display: inline-block;
}

.top_nav_naver {
	height: 35px;
	float: left;
}
.chat{
	width: 37px;
	
}
.top_nav_loginInfo {
	padding-top: 8px;
	padding-right: 5px;
	height: 35px;
	float: right;
}
.top_nav_naver:link {
	color: #03c75a;
}
top_nav_naver:visited {
	top_nav_naver
}
.top_nav_naver
</style>
</head>
<body>

	<div class="top_nav">
		<div class="top_nav_naver">
			<a class="navericon" href="http://naver.com"><h2>NAVER</h2></a>
		</div>
		<div class="top_nav_loginInfo">
			<c:choose>
				<c:when test="${memberInfo != null }">
					<img class="chat"src="img/chat.png">
          '${memberInfo.member_nickname }'님 환영합니다.
        </c:when>
				<c:otherwise>
          로그인 정보가 없습니다.
        </c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>