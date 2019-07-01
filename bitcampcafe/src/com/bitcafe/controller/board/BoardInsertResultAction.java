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
import com.bitcafe.util.ForwardAction;

public class BoardInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession  session=request.getSession();
		
		MemberDTO memberInfo=(MemberDTO)session.getAttribute("memberInfo");
		ForwardAction forward = new ForwardAction();
		
		
		if(memberInfo==null)
		{
		     forward.setRedirect(true);
		     forward.setPath("login.do");
			
		} else
		{
			String board_title = request.getParameter("board_title");
			String board_content = request.getParameter("board_content");
			int category_no = Integer.parseInt(request.getParameter("category_no"));
			int member_no = Integer.parseInt(request.getParameter("member_no"));
			BoardDTO dto =new BoardDTO();
			dto.setBoard_title(board_title);
			dto.setBoard_content(board_content);
			dto.setCategory_no(category_no);
			dto.setMember_no(member_no);
			
			//서비스 클래스를 불러와서 메서드를 사용한다.
			BoardService service = BoardService.getInstance();
			//서비스 클래스 안에 있는 insertservice 메서드를 사용
			int result = service.BoardInsertService(dto);
			int myboard = service.getMyboard(member_no);//
			int mycomment = service.getMyComment(member_no);//
			request.setAttribute("myboard", myboard);//
			request.setAttribute("mycomment", mycomment);//
			request.setAttribute("result", result);
			forward.setRedirect(true);
			forward.setPath("boardlist.do?cno="+category_no);
		}
				return forward;
	}

}
