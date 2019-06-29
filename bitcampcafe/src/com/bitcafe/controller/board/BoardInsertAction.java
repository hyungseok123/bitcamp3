package com.bitcafe.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
import com.bitcafe.util.ForwardAction;

public class BoardInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberInfo");
		ForwardAction act = new ForwardAction();
		if (memberInfo == null) {
	        act.setRedirect(true);
	        act.setPath("login.do");
		} else {
			int category_no = Integer.parseInt(request.getParameter("cno"));
			BoardService service = BoardService.getInstance();
			String category_name = service.getCategoryName(category_no);
			request.setAttribute("category_name", category_name);
			act.setRedirect(false);
			act.setPath("/cafe/template/main.jsp?page=/cafe/board/boardinsert.jsp");	
		}
		return act;
	}
}
