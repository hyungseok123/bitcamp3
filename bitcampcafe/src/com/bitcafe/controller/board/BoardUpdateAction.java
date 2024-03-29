package com.bitcafe.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
import com.bitcafe.service.CommentService;
import com.bitcafe.service.MemberService;
import com.bitcafe.util.ForwardAction;

import sun.print.resources.serviceui;

public class BoardUpdateAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		ForwardAction forward = new ForwardAction();
		int board_no = Integer.parseInt(request.getParameter("no"));
		MemberDTO memberInfo=(MemberDTO)session.getAttribute("memberInfo");
		if(memberInfo == null)
		{
		     forward.setRedirect(true);
		     forward.setPath("login.do");
			
		} else {
		BoardService service = BoardService.getInstance();
		BoardDTO dto = service.BoardDetailService(board_no);
		request.setAttribute("dto", dto);
		
		int member_no = memberInfo.getMember_no();
		request.setAttribute("memberInfo", memberInfo);
		// 나의 정보
		int myboard = service.getMyboard(member_no);
		int mycomment = service.getMyComment(member_no);
		request.setAttribute("myboard", myboard);
		request.setAttribute("mycomment", mycomment);
		
		forward.setRedirect(false);
		forward.setPath("/cafe/template/main.jsp?page=/cafe/board/boardupdate.jsp");
		}
		return forward;
	}
}
