package com.bitcafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.controller.Action;
import com.bitcafe.util.ForwardAction;

public class MemberLoginSuccessAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/login/logintest.jsp");
		return forward;
	}

}
