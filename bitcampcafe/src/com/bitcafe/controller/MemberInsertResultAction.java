package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.service.MemberService;
import com.bitcafe.util.ForwardAction;

public class MemberInsertResultAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String member_id = request.getParameter("member_id");
		String member_pwd = request.getParameter("member_pwd1");
		String member_nickname = request.getParameter("member_nickname");
		
		MemberDTO memberdto = new MemberDTO();
		memberdto.setMember_id(member_id);
		memberdto.setMember_pwd(member_pwd);
		memberdto.setMember_nickname(member_nickname);
		
		MemberService memberservice = MemberService.getInstance();
		memberservice.memberInsert(memberdto);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("/bitcampcafe/login/loginpage.jsp");
		return forward;
	}

}
