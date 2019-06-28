package com.bitcafe.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.util.ForwardAction;

public class BoardInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberInfo");
		ForwardAction act = new ForwardAction();
		 System.out.println("memberInfo"+memberInfo);
		if (memberInfo == null) {
	        act.setRedirect(true);
	        act.setPath("/login.do");
		}
		else {
			act.setRedirect(false);
			act.setPath("/cafe/board/boardinsert.jsp");	
			
		}
		
		return act;
	}

}
