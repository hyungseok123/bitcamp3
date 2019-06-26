package com.bitcafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.JsonAction;
import com.bitcafe.service.MemberService;

public class MemberNicknameOverlapCheckJsonAction implements JsonAction {

	@Override
	public JSONObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("memberInfo");
		String session_member_nickname = null;
		if(obj != null) {
			MemberDTO memberdto = (MemberDTO)obj;
			session_member_nickname = memberdto.getMember_nickname();
		}
		
		String member_nickname = request.getParameter("member_nickname");
		MemberService memberservice = MemberService.getInstance();
		boolean result = memberservice.memberNicknameOverlapCheck(member_nickname, session_member_nickname);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json;
	}

}
