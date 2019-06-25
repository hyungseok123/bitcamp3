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
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		AttendanceService service = AttendanceService.getService();
		AttendanceDTO dto = (AttendanceDTO)service.list();
		request.setAttribute("dto", dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("cafe/update.do");
		
		
		return forward;
	
	}

}
