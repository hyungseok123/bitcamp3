package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		    
		   HttpSession session=    request.getSession();
           MemberDTO dto=(MemberDTO) session.getAttribute("memberInfo");		     
   		ForwardAction forward = new ForwardAction();

           if(dto==null)
		  {
              forward.setRedirect(true);
              forward.setPath("login.do");
		  }
		  else
		  {
				forward.setRedirect(false);
				forward.setPath("/cafe/attendance/attendanceinsert.jsp");
		  }
		
		
	return forward;	
}
	
}