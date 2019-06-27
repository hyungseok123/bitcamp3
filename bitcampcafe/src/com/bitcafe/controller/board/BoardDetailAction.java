package com.bitcafe.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class BoardDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		CommentService commentService = CommentService.getService();
		int board_no = 0;
		String no = request.getParameter("no");
		if (no != null && !no.equals("")) board_no = Integer.parseInt(no);
		BoardDTO dto = service.BoardDetailService(board_no);
		int commentTotalCount = commentService.commentTotalCount();
		request.setAttribute("dto", dto);
		request.setAttribute("commentTotalCount", commentTotalCount);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/template/content.jsp?page=/cafe/board/boarddetail.jsp");
		return forward;
	}

}
