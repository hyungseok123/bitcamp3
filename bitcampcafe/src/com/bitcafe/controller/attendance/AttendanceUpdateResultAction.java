package com.bitcafe.controller.attendance;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.AttendanceService;
import com.bitcafe.service.BoardService;
import com.bitcafe.util.ForwardAction;

public class AttendanceUpdateResultAction implements Action {
// 수정요망
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서비스 클래스 호출
		AttendanceService service=AttendanceService.getService();
		// 로그인 세션
		HttpSession session = request.getSession();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		// forward, sendredirect 결정과 path 설정하기위해 forward 클래스 호출
		ForwardAction forward = new ForwardAction();
		if (loginInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			// jsp에서 보낸 파라미터 호출
			int member_no = loginInfo.getMember_no();
			BoardService Bservice = BoardService.getInstance();
			int myboard = Bservice.getMyboard(member_no);
			int mycomment = Bservice.getMyComment(member_no);
			request.setAttribute("myboard", myboard);
			request.setAttribute("mycomment", mycomment);
			
			int attendance_no = Integer.parseInt(request.getParameter("attendance_no"));
			String attendance_content = request.getParameter("attendance_content");
			int result = service.AttendanceUpdate(attendance_no, attendance_content);
			forward.setRedirect(true);
			//forward.setPath("/cafe/template/main.jsp?page=/cafe/attendance/attendancetinsert.jsp");
			forward.setPath("attendanceinsert.do");
		}
		return forward;
	
		
		
		
		
	}

}
