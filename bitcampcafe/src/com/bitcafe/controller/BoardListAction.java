package com.bitcafe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.service.BoardService;
import com.bitcafe.util.ForwardAction;

public class BoardListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 
		//현재페이지
		String curr = request.getParameter("currpage");
		int currpage= 1;
		if(curr!=null) {
			currpage = Integer.parseInt(curr);
		}
		
		//1페이지에 보여지는 자료의 수 	
		int pagepercount = 10; 
		
		//service 호출 
		BoardService service=BoardService.getInstance();
		//service에서 있는 getCount를 받아서 totalcount값으로 넣기
		int totalcount = service.getCount();
		
		//totalpage 계산!
		//int totalpage = Math.ceil(totalcount/(double)pagepercount);
		int totalpage=(totalcount/pagepercount)+((totalcount%pagepercount==0)? 0:1);
	
		//시작페이지 계산!
		int startrow=(currpage-1)*pagepercount+1;
		
		//끝페이지 계산!
		int endrow = startrow+pagepercount-1;
		if(endrow>totalcount)
			endrow=totalcount;
		
		//block에 관한 정보를 계산!
		//한 블록에 5개 보여줌 ->1 2 3 4 5 <다음>  <이전> 6 7 8 9 10 <다음>
		
		int blocksize=5;
		
		//1부터 5까지 보여지는 목록 만들기->1 2 3 4 5 <다음>
		int startblock=((currpage-1)/blocksize)*blocksize+1;
		int endblock=startblock+blocksize-1;
		if(totalpage<endblock)
			endblock=totalpage;
		
		// arrylist로 자료 받아서 dto로 넣기->service에 getList메서드 만들기
		List<BoardDTO> list = service.getList(startrow,endrow);
		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("currpage", currpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock",endblock);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/main.jsp");
		
		
		return forward;
	}
	 

}
