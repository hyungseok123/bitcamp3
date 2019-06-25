package com.bitcafe.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.attendanceDTO;
import com.bitcafe.service.attendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceUpdateResultAction implements Action {
// 수정요망
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String content=request.getParameter("content");
		Date writedate = Date(request.getParameter("writedate"));
		int mno = Integer.parseInt(request.getParameter("no"));
		attendanceDTO dto = new attendanceDTO();
		dto.setAttendance_no(no);
		dto.setAttendance_content(content);
		dto.setAttendance_writedate(writedate);
		dto.setMember_no(mno);
		
		attendanceService service=attendanceService.getService();
		int result = service.AttendanceUpdate(dto);
		
		
		
		return "/list.do";
	}

}
