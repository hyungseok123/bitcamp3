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

public class AttendanceInsertResultAction implements Action {
//수정할것!!!
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
        //MemberDTO dto=(MemberDTO)session.getAttribute("memberInfo");
    	MemberDTO dto=new MemberDTO();
    	dto.setMember_no(1);
		//session.setAttribute("memberInfo", dto);
		ForwardAction forward = new ForwardAction();
    	    
        if(dto!=null)
        {
        String attendance = request.getParameter("attendance");
         System.out.println(attendance);
         System.out.println(dto.getMember_no());
        AttendanceService service = AttendanceService.getService();
		service.AttendanceInsert(attendance, dto.getMember_no());
		
		
		
		forward.setRedirect(false);
		forward.setPath("/cafe/attendance/attendance.jsp");
	    }
        else 
        {
        	System.out.println("2");
        	forward.setRedirect(true);
        	forward.setPath("login.do");
        }
        return forward;
	}


}
