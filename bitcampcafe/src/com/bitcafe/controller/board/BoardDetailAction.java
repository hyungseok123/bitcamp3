package com.bitcafe.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.DTO.MemberDTO;
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
	// 로그인 정보 받아오기
		HttpSession session = request.getSession();
		ForwardAction forward = new ForwardAction();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		if (loginInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			BoardDTO dto = service.BoardDetailService(board_no);
			int commentTotalCount = commentService.commentTotalCount(board_no);
			request.setAttribute("dto", dto);
			request.setAttribute("commentTotalCount", commentTotalCount);
			request.setAttribute("loginNo", loginInfo);
			forward.setRedirect(false);
			forward.setPath("/cafe/template/content.jsp?page=/cafe/board/boarddetail.jsp");
		}
		return forward;
	}

}
