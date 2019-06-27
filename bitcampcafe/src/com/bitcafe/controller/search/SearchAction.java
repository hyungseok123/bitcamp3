package com.bitcafe.controller.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.SearchService;
import com.bitcafe.util.ForwardAction;
import com.bitcafe.util.Paging;

public class SearchAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchtext = request.getParameter("searchinput");
		String searchselect1 = request.getParameter("searchselect1");
		String searchselect2 = request.getParameter("searchselect2");
		String tmp_currpage = request.getParameter("currpage");
		
		int currpage = 1;
		if(tmp_currpage != null) { //처음들어온게 아니라면 값을 받아줌
			currpage = Integer.parseInt(tmp_currpage);
		}
		if(searchselect1 == null) { //카테고리 기본 설정값
			searchselect1 = "전체게시판";
		}
		if(searchselect2 == null) { //선택 기본 설정값
			searchselect2 = "제목+내용";
		}
		
		SearchService searchservice = SearchService.getInstance();
		int totalcount = searchservice.searchBoardCount(searchtext, searchselect1, searchselect2);
		System.err.println("카운트 : "+totalcount); //
		Paging paging = new Paging();
		paging.setCurrpage(currpage);
		paging.setTotalcount(totalcount);
		int totalpage = paging.getTotalpage();
		int startrow = paging.getStartrow();
		int endrow = paging.getEndrow();
		int startblock = paging.getStartblock();
		int endblock = paging.getEndblock();
		int blocksize = paging.getBlocksize();
		System.out.println("start "+startrow); //
		System.out.println("end "+endrow); //
		List<BoardDTO> list = searchservice.searchBoard(searchtext, searchselect1, searchselect2, startrow, endrow);
		request.setAttribute("list", list);
		request.setAttribute("searchtext", searchtext);
		
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("blocksize", blocksize);
		request.setAttribute("currpage", currpage);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/search/searchpage.jsp");
		
		return forward;
	}

}
