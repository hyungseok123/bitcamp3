package com.bitcafe.controller.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.util.ForwardAction;

public class CalendarListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("listAction들어옴");
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
