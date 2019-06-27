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

public class CommentReplyAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
		HttpSession session = request.getSession();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		CommentDTO dto = service.getCommentDetail(comment_no);
		request.setAttribute("dto", dto);
		request.setAttribute("loginNo", loginInfo);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/comment/replyform.jsp");
		return forward;
	}

}
