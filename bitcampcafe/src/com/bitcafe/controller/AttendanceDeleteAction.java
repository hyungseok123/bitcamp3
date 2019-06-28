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
		
		  // 파라미터값 받아오기
		int no = Integer.parseInt(request.getParameter("no"));
		
		  // 서비스 작동하고 attribute set 해주기
		AttendanceService service = AttendanceService.getService();
		int result = service.AttendanceDelete(no);
		request.setAttribute("result", result);
		
		  // forward, sendredirect 설정하고 경로도 설정
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("attendanceinsert.do");
		return forward;
	}

}
