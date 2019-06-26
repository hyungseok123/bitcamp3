package com.bitcafe.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bitcafe.controller.JsonAction;
import com.bitcafe.controller.member.MemberIdOverlapCheckJsonAction;
import com.bitcafe.controller.member.MemberLoginResultJsonAction;
import com.bitcafe.controller.member.MemberNicknameOverlapCheckJsonAction;

@WebServlet("*.json")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		req(request, response);
	}
	
	private void req(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		JsonAction jact = null;
		if(path.equals("/memberidcheck.json")) {
			jact = new MemberIdOverlapCheckJsonAction();
		} else if(path.equals("/membernicknamecheck.json")) {
			jact = new MemberNicknameOverlapCheckJsonAction();
		} else if(path.equals("/memberloginresult.json")) {
			jact = new MemberLoginResultJsonAction();
		}
		
		JSONObject json = jact.execute(request, response);
		response.getWriter().print(json);
	}
		
}
