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

public class MemberLoginResultJsonAction implements JsonAction {

	@Override
	public JSONObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String member_pwd = request.getParameter("member_pwd");
		
		MemberService memberservice = MemberService.getInstance();
		MemberDTO memberInfo = memberservice.memberLogin(member_id, member_pwd);
		boolean result = false;
		if(memberInfo.getMember_nickname()!=null) { //로그인 정보가 맞으면
			result = true;
			HttpSession session = request.getSession(true);
			session.setAttribute("memberInfo", memberInfo);
		}
		JSONObject json = new JSONObject();
		json.put("result", result);
		
		return json;
	}

}
