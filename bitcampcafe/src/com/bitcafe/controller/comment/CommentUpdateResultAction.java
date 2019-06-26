package com.bitcafe.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentUpdateResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		String content = request.getParameter("content");
		int result = service.commentUpdate(comment_no, content);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("commentlist.do");
		return forward;
	}

}
