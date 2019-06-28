package com.bitcafe.controller.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.bitcafe.service.CalendarService;




public class CalendarJsonAction implements GetJsonAction {
	@Override
	public JSONArray execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		CalendarService service = CalendarService.getCalendarService();
		JSONArray jsonArr = service.JsonService();
		return jsonArr;
	}
}
