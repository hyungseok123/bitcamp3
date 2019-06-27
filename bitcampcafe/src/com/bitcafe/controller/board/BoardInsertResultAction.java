package com.bitcafe.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
import com.bitcafe.util.ForwardAction;

public class BoardInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		int category_no = Integer.parseInt(request.getParameter("category_no"));
		int member_no = Integer.parseInt(request.getParameter("member_no"));
		BoardDTO dto =new BoardDTO();
		dto.setBoard_title(board_title);
		dto.setBoard_content(board_content);
		dto.setCategory_no(category_no);
		dto.setMember_no(member_no);
		BoardService service = BoardService.getInstance();
		int result = service.BoardInsertService(dto);
		request.setAttribute("result", result);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("boardlist.do");
		return forward;
	}


}
