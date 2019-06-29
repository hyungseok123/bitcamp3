<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

#btn{
   width:100px;
   height:80px;
   background-color:#03c75a;
   color:white;
   
   position:relative;
   bottom:35px;
}
.bitat{
  font-weight:bolder;
  font-size:20px;
  text-align:center;
  padding-bottom:5px;

}





</style>



<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({
        url:'http://localhost:8080/bitcampcafe/attendancelist.do'		
	   ,success:function(data)
	   {
		   console.log("success");
		   console.log(data);
		   $('#result').append(data);
	   }
	,error:function(data)
	{
	   	console.log('error');
	}
	
	 });
	
});
</script>
</head>
<body>
<div class="bitat">비트카페 출석하기</div>
<form id="frm" method = "post"  action="attendanceinsertresultaction.do">
 <textarea name="attendance" cols="100" rows="8"></textarea>
    <input type="submit" id="btn" value="출석!" >


</form>
<div id="result"> 
 
</div>
</body>
</html>