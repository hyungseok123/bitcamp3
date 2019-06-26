package com.bitcafe.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.MemberService;
import com.bitcafe.util.ForwardAction;

public class MemberDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("memberInfo");
		
		if(obj != null){
			MemberDTO memberdto = (MemberDTO)obj;
			int member_no = memberdto.getMember_no();
			MemberService memberservice = MemberService.getInstance();
			memberservice.memberDelete(member_no);
			session.removeAttribute("memberInfo"); //세션삭제
		}
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("login.do");
		
		return forward;
	}

}
