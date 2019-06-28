<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>풀캘린더</title>
<style type="text/css">
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>
<!-- 부트스트랩 플러그인-->
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
<!--  -->

<!-- datetimepicker -->
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/lib/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/lib/bootstrap-datetimepicker.min.css"></script>
<!--  -->

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<link href="./cafe/calendar/fullcalendar-3.3.1/fullcalendar.css"
	rel="stylesheet" />
<link href="./cafe/calendar/fullcalendar-3.3.1/fullcalendar.print.css"
	rel="stylesheet" media="print" />
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/lib/moment.min.js"></script>
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/lib/jquery.min.js"></script>
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/fullcalendar.js"></script>
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/locale/ko.js"></script>
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/gcal.js"></script>
<script type="text/javascript"
	src="./cafe/calendar/fullcalendar-3.3.1/lib/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		getEvent();
	});

	//list 데이터 json형식으로 받아주기
	function getEvent() { // 제이슨으로 캘린더 이벤트 등록형식에 맞게 뿌리기
		$.ajax({
			url : "http://localhost:8080/bitcampcafe/json.getjson",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			type : 'post',
			dataType : 'json',
			success : function(data) {
				console.log("getevent성공");
				eventData = [];
				$.each(data, function(index, element) {
					eventData.push({
						title : element.calendar_title,
						start : element.calendar_start,
						end : element.calendar_end,
						no : element.calendar_no,
						color : element.calendar_color
					});

				});

				calendarEvent(eventData); //캘린더 메소드 호출		
			},
			error : function(data) {
				console.log("getevent실패");
			}
		});
	}

	//Calendar이벤트!!!!!! 본격 시작
	function calendarEvent(eventData) {
		$("#calendar").fullCalendar({
			selectable : true,
			header : {
				left : 'prev,next',
				center : 'title',
				right : 'today,month'
			},
			editable : false,
			events : eventData,
			select : function(event) {
				//일정없는 빈곳 누르면 insertform으로~

				location.href = "calendarinsert.do";
			},
			eventClick : function(event) { //일정클릭하면 그일정의 디테일을 출력			
				if (event.no) {
					location.href = "calendarDetail.do?no=" + event.no;
					return false;
				}
			}
		});
	}
</script>
<body>

	<div id="calendar"></div>



</body>
</html>
