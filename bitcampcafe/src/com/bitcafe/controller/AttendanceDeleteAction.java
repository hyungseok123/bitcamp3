package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.service.attendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceDeleteAction implements Action {
//수정요망 !!!
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		attendanceService service = attendanceService.getService();
		int result = service.AttendanceDelete(no);
		request.setAttribute("result", result);
		
		return "/del.jsp";
	}

}
