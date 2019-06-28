package com.bitcafe.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceUpdateResultAction implements Action {
// 수정요망
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AttendanceService service=AttendanceService.getService();
		
		
		int no=Integer.parseInt(request.getParameter("no"));
		String attendance_content = request.getParameter("attendance_content");
		//request.setAttribute("content", content);
		int bno = 0;
		
		
		HttpSession session = request.getSession();
		ForwardAction forward = new ForwardAction();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		if (loginInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			int attendance_no = Integer.parseInt(request.getParameter("attendance_no"));
			String content = request.getParameter("attendance_content");
			int result2 = service.AttendanceUpdate(attendance_no, attendance_content);
			forward.setRedirect(true);
			forward.setPath("/cafe/attendance/attendanceupdate.jsp");
		}
		return forward;
	
		
		
		
		
	}

}
