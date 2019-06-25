package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.attendanceDTO;
import com.bitcafe.service.attendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceUpdateAction implements Action {
 // 내일 수정할것!!!!!!!!!!!!!!!!!
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		attendanceService service = attendanceService.getService();
		attendanceDTO dto = (attendanceDTO)service.list();
		request.setAttribute("dto", dto);
		
		
		
		
		return "modify.jsp";
	
	}

}
