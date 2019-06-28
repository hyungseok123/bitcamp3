package com.bitcafe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.util.ForwardAction;

public class AttendanceListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*String curr=request.getParameter("currpage");
		int currpage=1;
		if(curr!=null)
		   currpage=Integer.parseInt(curr);
		int pagesize=10; //1페이지에 보여질 자료
*/	    AttendanceService service = AttendanceService.getService();
		//int totalcount = service.getCount(); 
	    //int totalpage = (int)Math.ceil(totalcount/pagepercount);
	   /* int totalpage=(totalcount/pagesize)+((totalcount%pagesize==0)? 0:1);
	    int startrow=(currpage-1)*pagesize+1;
	    int endrow = startrow+pagesize-1;
	    if(endrow>totalcount)
	       endrow=totalcount;
	    int blocksize=5; 
	    //totalpage:7    1...5   6 7
	    //1블럭당 5개 ..1부터 5페이지까지 보여주는 목록
	    int startblock=((currpage-1)/blocksize)*blocksize+1;
	    int endblock = startblock+blocksize-1;
	    if(totalpage<endblock)
	    	endblock=totalpage;
	
	    List<AttendanceDTO> list = service.list(startrow, pagesize);
	     */
        List<AttendanceDTO> list=service.list();
	    request.setAttribute("list", list);
	    System.out.println("fwffewfewf"+list);
	   /* request.setAttribute("totalpage", totalpage);
	    request.setAttribute("currpage", currpage);
	    request.setAttribute("startblock", startblock);
	    request.setAttribute("endblock", endblock);*/
	    ForwardAction forward = new ForwardAction();
	    forward.setRedirect(false);
	    forward.setPath("/cafe/template/main.jsp?page=/cafe/attendance/attendance.jsp");
	    
	    
	    
		return forward;
		
		
		
		/*AttendanceService service = AttendanceService.getService();
		List<AttendanceDTO> list = service.list();
		request.setAttribute("list", list);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/attendance/attendance.jsp");
		return forward;*/
	}

}
