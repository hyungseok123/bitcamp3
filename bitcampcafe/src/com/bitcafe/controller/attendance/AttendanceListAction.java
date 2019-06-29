package com.bitcafe.controller.attendance;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	    AttendanceService service = AttendanceService.getService();
		
        List<AttendanceDTO> list=service.list();
	    request.setAttribute("list", list);
	    System.out.println("fwffewfewf"+list);
	  
	    ForwardAction forward = new ForwardAction();
	    forward.setRedirect(false);
	    forward.setPath("/cafe/attendance/attendance.jsp");
	    
	    
	    
		return forward;
		
		
		
		
	}

}
