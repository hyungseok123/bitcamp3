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
		HttpSession session = request.getSession();
		CommentService service = CommentService.getService();
		ForwardAction forward = new ForwardAction();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		if (loginInfo == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			int member_no = loginInfo.getMember_no();
			List<CommentDTO> list = service.commentList();
			request.setAttribute("list", list);
			request.setAttribute("loginNo", member_no);
			forward.setRedirect(false);
			forward.setPath("/cafe/comment/comment.jsp");
		}
		return forward;
	}

}
