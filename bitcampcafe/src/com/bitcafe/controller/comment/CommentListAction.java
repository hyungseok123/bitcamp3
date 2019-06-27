package com.bitcafe.controller.comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// board_no 파라미터값 받아오기
		int bno = 0;
		String no = request.getParameter("board_no");
		if (no != null && !no.equals("")) bno = Integer.parseInt(no);
		System.out.println(no);
		HttpSession session = request.getSession();
		CommentService service = CommentService.getService();
		ForwardAction forward = new ForwardAction();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		System.out.println();
		if (loginInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			int member_no = loginInfo.getMember_no();
			List<CommentDTO> list = service.commentList(bno);
			request.setAttribute("list", list);
			request.setAttribute("loginNo", member_no);
			request.setAttribute("board_no", bno);
			forward.setRedirect(false);
			forward.setPath("/cafe/comment/comment.jsp");
		}
		return forward;
	}

}
