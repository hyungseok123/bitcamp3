$(document).ready(function() {
  displayLoading(true);
  $.ajax({
   
     type : "POST" //"POST", "GET"
     , url : "/calendarAjax.do" //Request URL //.do
     , dataType : "json" //전송받을 데이터�� 타입
                 , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
     , error : function(request, status, error) {
     alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
     }
     , success : function(data) {
     setCalendar(data.data);
     displayLoading(false);s
    }
   });
  
 
 });
 
 function setCalendar( data ){
  var date = new Date();
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();
  var jsonData = JSON.stringify(data).replace(/\"/gi,"");
 
  
  $('#calendar').fullCalendar({
   editable: false,
   events: eval(jsonData)
  });
  
  $("#calendar a").click(function(){
   
   $(this).attr("href","javascript:goDetail('"+$(this).attr("href")+"')");
  });
 
  
 }
