package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bitcafe.service.MemberService;

public class MemberIdOverlapCheckJsonAction implements JsonAction {

	@Override
	public JSONObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		MemberService memberservice = MemberService.getInstance();
		boolean result = memberservice.memberIdOverlapCheck(member_id);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json;
	}

}
