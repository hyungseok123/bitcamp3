package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.service.MemberService;
import com.bitcafe.util.ForwardAction;

public class MemberUpdateAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tmp_member_no = request.getParameter("member_no");
		ForwardAction forward = new ForwardAction();
		MemberDTO memberdto = null;
		if(tmp_member_no == null) { //로그인이 안되어 잇을시 로그인페이지로 이동
			forward.setRedirect(true);
			forward.setPath("/bitcampcafe/login/loginpage.jsp");
		}
		else {
			int member_no = Integer.parseInt(tmp_member_no);
			MemberService memberservice = MemberService.getInstance();
			memberdto = memberservice.memberDetail(member_no);
			HttpSession session = request.getSession();
			session.setAttribute("memberdto", memberdto);
			forward.setRedirect(true);
			forward.setPath("/bitcampcafe/login/memberupdatepage.jsp");
		}
		return forward;
	}

}
