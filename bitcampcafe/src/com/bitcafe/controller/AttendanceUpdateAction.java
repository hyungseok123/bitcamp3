package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceUpdateAction implements Action {
 // 내일 수정할것!!!!!!!!!!!!!!!!!
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//파라미터값을 받아와보기
		int no = Integer.parseInt(request.getParameter("no"));
        AttendanceService service = AttendanceService.getService();
        String content = service.AttendanceContent(no);
        
		
		//서비스를 작동하고 x attribute를 세팅하기
		request.setAttribute("attendance_no", no);
		request.setAttribute("content", content);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/attendance/attendanceupdate.jsp");
		return forward;	
	}
}