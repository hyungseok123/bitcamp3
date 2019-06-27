package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceDeleteAction implements Action {
//수정요망 !!!
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AttendanceService service = AttendanceService.getService();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		AttendanceDTO dto = new AttendanceDTO();
		int result = service.AttendanceDelete(dto);
		request.setAttribute("result", result);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/attendance/attendancedelete.do");
		
		
		
		
		return forward;
	}

}
