<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.form-style-5 {
	max-width: 500px;
	padding: 10px 20px;
	background: #f4f7f8;
	margin: 10px auto;
	padding: 20px;
	background: #f4f7f8;
	border-radius: 8px;
	font-family: Georgia, "Times New Roman", Times, serif;
}

.form-style-5 fieldset {
	border: none;
}

.form-style-5 legend {
	font-size: 1.4em;
	margin-bottom: 10px;
}

.form-style-5 label {
	display: block;
	margin-bottom: 8px;
}

.form-style-5 input[type="text"], .form-style-5 input[type="date"],
	.form-style-5 input[type="datetime"], .form-style-5 input[type="email"],
	.form-style-5 input[type="number"], .form-style-5 input[type="search"],
	.form-style-5 input[type="time"], .form-style-5 input[type="url"],
	.form-style-5 textarea, .form-style-5 select {
	font-family: Georgia, "Times New Roman", Times, serif;
	background: rgba(255, 255, 255, .1);
	border: none;
	border-radius: 4px;
	font-size: 15px;
	margin: 0;
	outline: 0;
	padding: 10px;
	width: 500px;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	background-color: #e8eeef;
	color: #b9c6b9;
	-webkit-box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	margin-bottom: 30px;
}

.form-style-5 input[type="text"]:focus, .form-style-5 input[type="date"]:focus,
	.form-style-5 input[type="datetime"]:focus, .form-style-5 input[type="email"]:focus,
	.form-style-5 input[type="number"]:focus, .form-style-5 input[type="search"]:focus,
	.form-style-5 input[type="time"]:focus, .form-style-5 input[type="url"]:focus,
	.form-style-5 textarea:focus, .form-style-5 select:focus {
	background: #b9c6b9;
}

.form-style-5 select {
	-webkit-appearance: menulist-button;
	height: 35px;
}

.form-style-5 .number {
	background: #03c75a;
	color: #fff;
	height: 30px;
	width: 30px;
	display: inline-block;
	font-size: 0.8em;
	margin-right: 4px;
	line-height: 30px;
	text-align: center;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.2);
	border-radius: 15px 15px 15px 0px;
}

.form-style-5 input[type="submit"], .form-style-5 input[type="button"] {
	position: relative;
	display: block;
	padding: 19px 39px 18px 39px;
	color: #FFF;
	margin: 0 auto;
	background: #03c75a;
	font-size: 18px;
	text-align: center;
	font-style: normal;
	width: 500px;
	border: 1px solid #16a085;
	border-width: 1px 1px 3px;
	margin-bottom: 10px;
}

.form-style-5 input[type="submit"]:hover, .form-style-5 input[type="button"]:hover
	{
	background: ##03c75a;
}
</style>
</head>
<body>
<div class="form-style-5">
		<form method="post" action="calendarinsertresult.do">
			<fieldset>
				<legend>
					<span class="number"></span> 일정 추가
				</legend>
				<input type="text" id="title" name="title" placeholder="일정 제목">
				<textarea id="calcontent" name="content" placeholder="일정 내용"></textarea>
				<input type="text" id="place" name="place" placeholder="일정 장소">
				<select name='color'>
					<option value='' selected>-- 색상 --</option>
					<option value='#ff6666' style='background-color: #ff6666'>시험</option>
					<option value='#66ff8c' style='background-color: #66ff8c'>공지</option>
					<option value='#66b3ff' style='background-color: #66b3ff'>과제</option>
					<option value='#ffff66' style='background-color: #ffff66'>스터디</option>
					<option value='#ffccff' style='background-color: #ffccff'>기타</option>
				</select> <label for="start">시작</label> <input type="date" id="start"
					name="start"> <label for="end">끝</label> <input type="date"
					id="end" name="end">
			</fieldset>
			<input type="submit" value="추가" />
		</form>
	</div>
	</body>
</html>