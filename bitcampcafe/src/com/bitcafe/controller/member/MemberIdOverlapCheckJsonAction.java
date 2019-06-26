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

public class MemberIdOverlapCheckJsonAction implements JsonAction {

	@Override
	public JSONObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("작동됨 !");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("memberInfo");
		String session_member_id = null;
		if(obj != null) {
			MemberDTO memberdto = (MemberDTO)obj;
			session_member_id = memberdto.getMember_id();
		}
		
		String member_id = request.getParameter("member_id");
		MemberService memberservice = MemberService.getInstance();
		boolean result = memberservice.memberIdOverlapCheck(member_id, session_member_id);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json;
	}

}
