package com.bitcafe.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.controller.Action;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
		int comment_no = Integer.parseInt(request.getParameter("dno"));
		int result = service.commentDelete(comment_no);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("commentlist.do");
		return forward;
	}

}
