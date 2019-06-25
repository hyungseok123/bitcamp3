package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bitcafe.service.MemberService;

public class MemberNicknameOverlapCheckJsonAction implements JsonAction {

	@Override
	public JSONObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String member_nickname = request.getParameter("member_nickname");
		MemberService memberservice = MemberService.getInstance();
		boolean result = memberservice.memberNicknameOverlapCheck(member_nickname);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json;
	}

}
