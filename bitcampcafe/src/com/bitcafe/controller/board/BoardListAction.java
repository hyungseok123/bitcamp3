package com.bitcafe.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSpinnerUI;

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
		 
		int category_no = 0;
		String cno = request.getParameter("cno");
		if (cno != null && !cno.equals("")) category_no = Integer.parseInt(cno);
		
//		페이징처리
		String tmp_currpage = request.getParameter("currpage");
		int currpage = 1;
		if (tmp_currpage != null) { // 처음들어온게 아니라면 값을 받아줌
			currpage = Integer.parseInt(tmp_currpage);
		}
		BoardService service = BoardService.getInstance();
		int totalcount = service.BoardGetCount(category_no);
		// 페이징 계산 시작
				Paging paging = new Paging();
				System.out.println(currpage);
				System.out.println(totalcount);
				paging.setCurrpage(currpage);
				paging.setTotalcount(totalcount);
				int totalpage = paging.getTotalpage();
				int startrow = paging.getStartrow();
				int endrow = paging.getEndrow();
				int startblock = paging.getStartblock();
				int endblock = paging.getEndblock();
				int blocksize = paging.getBlocksize();
				// 페이징 계산 끝
				
				System.out.println("start : " + startrow); //
				System.out.println("end : " + endrow); //
				List<BoardDTO> pagelist = service.BoardPageList(startrow, endrow, category_no);
				request.setAttribute("pagelist", pagelist);
				request.setAttribute("totalpage", totalpage);
				request.setAttribute("startblock", startblock);
				request.setAttribute("endblock", endblock);
				request.setAttribute("blocksize", blocksize);
				request.setAttribute("currpage", currpage);
				request.setAttribute("null2", "[]"); // []를 위해서 만듬(jstl은 오류로인식함)
		
	//여기까지
		
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
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/template/main.jsp?page=/cafe/board/boardlist.jsp");
		return forward;
	}

}
