package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.util.ForwardAction;

public class MemberInsertResultAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		System.out.println("member_id : "+member_id);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("http://localhost:8080/bitcampcafe/login/loginpage.jsp");
		return forward;
	}

}
