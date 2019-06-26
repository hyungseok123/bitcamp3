package com.bitcafe.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
import com.bitcafe.util.ForwardAction;

public class BoardDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		int boardnum = 1;
		if (num != null && !num.equals(""))
			boardnum = Integer.parseInt(num);

		BoardService service = BoardService.getInstance();
		BoardDTO data = service.BoardDetailService(boardnum);
		request.setAttribute("data", data);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/board/boarddetail.jsp");

		return forward;
	}

}
