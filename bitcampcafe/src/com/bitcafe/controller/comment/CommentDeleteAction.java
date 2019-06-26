package com.bitcafe.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.controller.Action;
import com.bitcafe.util.ForwardAction;

public class CommentDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("commentlist.do");
		return forward;
	}

}
