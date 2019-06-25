package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
		String content = request.getParameter("content");
		// login session 정보 #############################################
		
		int member_no = 1; 
		
		// 나중에 고칠 부분 ###############################################
		int result = service.commentInsert();
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("/cafe/main.jsp?page=comment.jsp");
		return forward;
	}

}
