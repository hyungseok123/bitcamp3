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

public class BoardUpdateResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 정보  
		HttpSession session = request.getSession();
		MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberInfo");
		ForwardAction forward = new ForwardAction();
		if (memberInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");

		} else {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			int member_no = memberInfo.getMember_no();
			BoardService service = BoardService.getInstance();
			String board_title = request.getParameter("board_title");
			String board_content = request.getParameter("board_content");
			int myboard = service.getMyboard(member_no);//
			int mycomment = service.getMyComment(member_no);//
			request.setAttribute("myboard", myboard);//
			request.setAttribute("mycomment", mycomment);//
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(board_no);
			dto.setBoard_title(board_title);
			dto.setBoard_content(board_content);
			
			int result = service.BoardUpdateService(dto);
			
			request.setAttribute("result", result);
			forward.setRedirect(true);
			forward.setPath("boarddetail.do?no=" + board_no);

		}

		return forward;
	}

}
