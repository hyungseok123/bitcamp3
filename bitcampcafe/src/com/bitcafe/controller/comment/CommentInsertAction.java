package com.bitcafe.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
		CommentDTO dto = new CommentDTO();
	// 댓글 내용
		String content = request.getParameter("content");
		dto.setComment_content(content);
	// 댓글 부모
		int parent = Integer.parseInt(request.getParameter("parent"));
		if (parent == 0) {
			parent = service.getMaxParent();
			dto.setComment_parent(parent + 1);
		} else {
			dto.setComment_parent(parent);
		}
	// 댓글 깊이
		int depth = Integer.parseInt(request.getParameter("depth"));
		dto.setComment_depth(depth);
	// 댓글 순서
		int order = 0;
		int parentOrder =Integer.parseInt(request.getParameter("parent"));
		if (parent != 0) order = service.getMaxOrder(parentOrder);
		dto.setComment_order(order + 1);
	// 게시판 번호
		int board_no = Integer.parseInt(request.getParameter("board_no"));	
		dto.setBoard_no(board_no);
	// 회원 번호
		int member_no  = Integer.parseInt(request.getParameter("member_no"));
		dto.setMember_no(member_no);
	// DB 추가	
		int result = service.commentInsert(dto);
		request.setAttribute("result", result);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("commentlist.do");
		return forward;
	}

}
