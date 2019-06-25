package com.bitcafe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
		List<CommentDTO> list = service.commentList();
		request.setAttribute("list", list);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/template/template.jsp?page=comment.jsp");
		return forward;
	}

}
