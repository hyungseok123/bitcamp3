package com.bitcafe.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.controller.Action;
import com.bitcafe.util.ForwardAction;

public class BoardInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ForwardAction act=new ForwardAction();
		act.setRedirect(false);
		act.setPath("cafe/board/boardinsert.jsp");
		
		return act;
	}

}
