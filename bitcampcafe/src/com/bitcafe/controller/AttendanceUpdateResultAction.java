package com.bitcafe.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceUpdateResultAction implements Action {
// 수정요망
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String content=request.getParameter("content");
		//request.setAttribute("content", content);
		AttendanceDTO dto = new AttendanceDTO();
		dto.setAttendance_content(content);	
		AttendanceService service=AttendanceService.getService();
		int result = service.AttendanceUpdate(dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("cafe/attendance.do");
	
		
		
		
		return forward;
	}

}
