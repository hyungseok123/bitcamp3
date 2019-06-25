package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.service.CommentService;
import com.bitcafe.util.ForwardAction;

public class CommentInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = CommentService.getService();
		CommentDTO dto = new CommentDTO();
		
		String content = request.getParameter("content");
		int comment_parent =  service.getMaxParent();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		// login session 정보 #############################################
		
		int member_no = 1; 
		
		// 나중에 고칠 부분 ###############################################
		dto.setComment_content(content);
		dto.setComment_parent(comment_parent + 1);
		dto.setBoard_no(board_no);
		dto.setMember_no(member_no);
		int result = service.commentInsert(dto);
		request.setAttribute("result", result);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("commentlist.do");
		return forward;
	}

}
