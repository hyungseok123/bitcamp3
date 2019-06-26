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

public class MemberUpdateResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO tmp_memberdto = (MemberDTO)session.getAttribute("memberInfo");
		String member_id = request.getParameter("member_id");
		String member_pwd = request.getParameter("member_pwd1");
		String member_nickname = request.getParameter("member_nickname");
		int member_no = tmp_memberdto.getMember_no();
		
		MemberDTO memberdto = new MemberDTO();
		memberdto.setMember_no(member_no);
		memberdto.setMember_id(member_id);
		memberdto.setMember_pwd(member_pwd);
		memberdto.setMember_nickname(member_nickname);
		
		MemberService memberservice = MemberService.getInstance();
		memberservice.memberUpdate(memberdto);
		
		session.removeAttribute("memberInfo"); //해당 세션을 삭제 (로그아웃)
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("login.do"); //로그인 페이지로 이동
		return forward;
	}

}
