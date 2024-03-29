package com.bitcafe.controller.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.CalendarDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
import com.bitcafe.service.CalendarService;
import com.bitcafe.util.ForwardAction;

public class CalendarModifyAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		CalendarService service = CalendarService.getCalendarService();
		CalendarDTO dto = service.DetailService(no);
		request.setAttribute("dto", dto);

		ForwardAction forward = new ForwardAction();
		HttpSession session = request.getSession();
		MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberInfo");
		if (memberInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			int member_no = memberInfo.getMember_no();
			BoardService Bservice = BoardService.getInstance();
			int myboard = Bservice.getMyboard(member_no);
			int mycomment = Bservice.getMyComment(member_no);
			request.setAttribute("myboard", myboard);
			request.setAttribute("mycomment", mycomment);
			forward.setRedirect(false);
			forward.setPath("/cafe/template/main.jsp?page=/cafe/calendar/calendarModify.jsp");

		}

		return forward;

	}

}
