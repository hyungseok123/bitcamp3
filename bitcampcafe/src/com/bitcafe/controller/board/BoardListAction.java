package com.bitcafe.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
import com.bitcafe.util.ForwardAction;
import com.bitcafe.util.Paging;

public class BoardListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		BoardService service=BoardService.getInstance();
		int category_no = 0;
		String cno = request.getParameter("cno");
		if (cno != null && !cno.equals("")) category_no = Integer.parseInt(cno);
		
		HttpSession session = request.getSession();
		MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberInfo");
		if (memberInfo != null) {
			int member_no = memberInfo.getMember_no();
			request.setAttribute("memberInfo", memberInfo);
			// 나의 정보
			int myboard = service.getMyboard(member_no);
			int mycomment = service.getMyComment(member_no);
			request.setAttribute("myboard", myboard);
			request.setAttribute("mycomment", mycomment);
		}
		List<BoardDTO> list= service.BoardListService(category_no);
=======
		BoardService service = BoardService.getInstance();
		List<BoardDTO> list = service.BoardListService();
>>>>>>> branch 'master' of https://github.com/hyungseok123/bitcamp3.git
		request.setAttribute("list", list);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/template/main.jsp?page=/cafe/board/boardlist.jsp");
		return forward;
	}

}
