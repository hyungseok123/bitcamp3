package com.bitcafe.controller.attendance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.service.BoardService;
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
			  int member_no = dto.getMember_no();
				BoardService Bservice = BoardService.getInstance();
				int myboard = Bservice.getMyboard(member_no);
				int mycomment = Bservice.getMyComment(member_no);
				request.setAttribute("myboard", myboard);
				request.setAttribute("mycomment", mycomment);
			  
			    forward.setRedirect(false);
				forward.setPath("/cafe/template/main.jsp?page=/cafe/attendance/attendancetem.jsp");
		  }
		
		
	return forward;	
}
	
}