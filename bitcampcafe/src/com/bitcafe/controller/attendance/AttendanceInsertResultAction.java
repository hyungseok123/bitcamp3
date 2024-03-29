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

public class AttendanceInsertResultAction implements Action {
	// 수정할것!!!
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("memberInfo");
		// MemberDTO dto=new MemberDTO();
		// dto.setMember_no(1);
		// session.setAttribute("memberInfo", dto);
		ForwardAction forward = new ForwardAction();

		/*	*/

		if (dto != null) {
			int member_no = dto.getMember_no();
			BoardService Bservice = BoardService.getInstance();
			int myboard = Bservice.getMyboard(member_no);
			int mycomment = Bservice.getMyComment(member_no);
			request.setAttribute("myboard", myboard);
			request.setAttribute("mycomment", mycomment);

			String attendance = request.getParameter("attendance");
			System.out.println(attendance);
			System.out.println(dto.getMember_no());
			AttendanceService service = AttendanceService.getService();
			service.AttendanceInsert(attendance, dto.getMember_no());

			forward.setRedirect(false);
			forward.setPath("/cafe/template/main.jsp?page=/cafe/attendance/attendanceinsert.jsp");
		} else {
			System.out.println("2");
			forward.setRedirect(true);
			forward.setPath("login.do");
		}
		return forward;
	}

}
