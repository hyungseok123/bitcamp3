package com.bitcafe.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentUpdateResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
	// board_no 파라미터값 받아오기
		int bno = 0;
		String no = request.getParameter("board_no");
		if (no != null && !no.equals("")) bno = Integer.parseInt(no);
	// 로그인 정보 받아오기
		HttpSession session = request.getSession();
		ForwardAction forward = new ForwardAction();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		if (loginInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			int comment_no = Integer.parseInt(request.getParameter("comment_no"));
			String content = request.getParameter("content");
			int result = service.commentUpdate(comment_no, content);
			forward.setRedirect(true);
			forward.setPath("boarddetail.do?no=" + bno);
		}
		return forward;
	}

}
