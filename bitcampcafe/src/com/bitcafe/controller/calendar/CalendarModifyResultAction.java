package com.bitcafe.controller.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.CalendarDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.CalendarService;
import com.bitcafe.util.ForwardAction;

public class CalendarModifyResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String content = request.getParameter("content");
		CalendarDTO dto = new CalendarDTO();
		dto.setCalendar_no(no);
		dto.setCalendar_title(title);
		dto.setCalendar_start(start);
		dto.setCalendar_end(end);
		dto.setCalendar_content(content);
		CalendarService service = CalendarService.getCalendarService();
		int result = service.ModifyService(dto);
		request.setAttribute("result", result);

		ForwardAction forward = new ForwardAction();
		HttpSession session = request.getSession();
		MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberInfo");
		if (memberInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			int member_no = memberInfo.getMember_no();
			forward.setRedirect(false);
			forward.setPath("/cafe/template/main.jsp?page=/cafe/calendar/calendarMain.jsp");

		}

		return forward;

	}

}
