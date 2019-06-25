package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.util.ForwardAction;

public class MemberInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("/bitcampcafe/login/memberinsertpage.jsp");
		
		return forward;
	}

}
