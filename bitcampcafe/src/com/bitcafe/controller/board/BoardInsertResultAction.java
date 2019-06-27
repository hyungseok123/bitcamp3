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

		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDTO dto =new BoardDTO();
		dto.setBoard_title(title);
		dto.setBoard_content(content);
		BoardService service = BoardService.getInstance();
		int result = service.BoardInsertService(dto);
		request.setAttribute("result", result);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("boardlist.do");
		return forward;
	}


}
