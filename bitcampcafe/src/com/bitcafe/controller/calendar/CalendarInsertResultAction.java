package com.bitcafe.controller.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.CalendarDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.CalendarService;
import com.bitcafe.util.ForwardAction;

public class CalendarInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String content = request.getParameter("content");
		String place = request.getParameter("place");
		String color = request.getParameter("color");
		CalendarDTO dto = new CalendarDTO();
		dto.setCalendar_title(title);
		dto.setCalendar_start(start);
		dto.setCalendar_end(end);
		dto.setCalendar_content(content);
		dto.setCalendar_place(place);
		dto.setCalendar_color(color);
		CalendarService service = CalendarService.getCalendarService();
		int result = service.InsertService(dto);
		request.setAttribute("result", result);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/calendar/calendarMain.jsp");
		return forward;
	}

}
