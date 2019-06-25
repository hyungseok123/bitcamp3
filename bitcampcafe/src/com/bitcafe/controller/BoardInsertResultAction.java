package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.service.BoardService;
import com.bitcafe.util.ForwardAction;

public class BoardInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		 
		BoardService service=BoardService.getInstance();
		service.BoardInsertService(title, content);
		ForwardAction forward=new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("/cafe/main.do");
		
		return forward;
	}


}
