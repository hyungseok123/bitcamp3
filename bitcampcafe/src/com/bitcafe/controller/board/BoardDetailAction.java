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
		BoardService service = BoardService.getInstance();
		int board_no = 0;
		String no = request.getParameter("no");
		if (no != null && !no.equals("")) board_no = Integer.parseInt(no);
		BoardDTO data = service.BoardDetailService(board_no);
		request.setAttribute("data", data);
		
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/board/boarddetail.jsp");
		return forward;
	}

}
