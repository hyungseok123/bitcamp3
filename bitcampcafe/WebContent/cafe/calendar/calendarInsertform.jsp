<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- datetimepicker -->
<script type="text/javascript"
	src="./fullcalendar-3.3.1/lib/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="./fullcalendar-3.3.1/lib/bootstrap-datetimepicker.min.css"></script>
<!--  -->
</head>
<body>
	<!--
	제목 title,  시작 start, 끝end   
	  -->
	<form method="post" action="calendarinsertresult.do">
		<div class="modal_fade" tabindex="-1" role="dialog" id="eventModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-xs-12">
								<label for="title">제목</label> <input type="text" id="title"
									name="title">
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<label for="content">내용</label> <input type="text" id="content"
									name="content">
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<label for="place">장소</label> <input type="text" id="place"
									name="place">
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<label for="color">색상</label> <input type="text" id="color"
									name="color">
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<label for="start">시작</label> <input type="text" id="start"
									name="start" placeholder="YYYY-MM-DD">
							</div>
						</div>


						<div class="row">
							<div class="col-xs-12">
								<label for="end">끝</label> <input type="text" id="end"
									name="end" placeholder="YYYY-MM-DD">
							</div>
						</div>

					</div>

					<div class="modal-footer modalBtnContainer-modifyEvent">
						<input type="submit" value="추가하기"> <a href="    .jsp">
							<input type="button" value="뒤로가기">
						</a>
					</div>


				</div>
			</div>
		</div>
	</form>
</body>
</html>