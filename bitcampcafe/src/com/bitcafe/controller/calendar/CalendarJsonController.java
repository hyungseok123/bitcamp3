package com.bitcafe.controller.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

@WebServlet("*.json")
public class CalendarJsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalendarJsonController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req(request, response);
	}
	
	private void req(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String path = request.getServletPath();
		System.out.println("path : "+path);
		GetJsonAction jact = null;
		
		if(path.equals("/json.json")) {
			jact = new CalendarJsonAction();
		}
		
		JSONArray jsonArr = jact.execute(request, response);
		response.getWriter().print(jsonArr);
	}
		
}