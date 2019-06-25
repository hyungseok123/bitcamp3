package com.bitcafe.controller;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceInsertResultAction implements Action {
//수정할것!!!
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		  int no = Integer.parseInt(request.getParameter("no"));
		  String content=request.getParameter("content");		
		Date writedate = Date(request.getParameter("writedate"));
		int mno=Integer.parseInt(request.getParameter("mno"));
			AttendanceDTO dto = new AttendanceDTO();
			dto.setAttendance_no(no);
			dto.setAttendance_content(content);
			dto.setAttendance_writedate(writedate);
			dto.setMember_no(mno);
			
			AttendanceService service=AttendanceService.getService();
			int result = service.AttendanceInsert(dto);
			request.setAttribute("result", result);
			ForwardAction forward = new ForwardAction();
			forward.setRedirect(false);
			forward.setPath("/cafe/attendance.do");
			
			
			return forward;
	}

}
