package com.bitcafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.controller.Action;
import com.bitcafe.util.ForwardAction;

public class MemberLogoutAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("memberInfo");
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/login/logoutpage.jsp");
		return forward;
	}

}
