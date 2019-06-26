package com.bitcafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.MemberService;
import com.bitcafe.util.ForwardAction;

public class MemberUpdateAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("memberInfo");
		ForwardAction forward = new ForwardAction();
		if(obj == null) { //로그인이 안되어 잇을시 로그인페이지로 이동
			forward.setRedirect(true);
			forward.setPath("login.do");
		}
		else { //로그인이 되어 있다면
			MemberDTO tmp_memberdto = (MemberDTO)obj;
			int member_no = tmp_memberdto.getMember_no();
			MemberService memberservice = MemberService.getInstance();
			MemberDTO memberdto = memberservice.memberDetail(member_no);
			session = request.getSession();
			session.setAttribute("memberdto", memberdto);
			forward.setRedirect(false);
			forward.setPath("/login/memberupdatepage.jsp");
		}
		return forward;
	}

}
