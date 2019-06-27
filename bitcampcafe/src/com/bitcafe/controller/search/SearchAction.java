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

public class SearchAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchtext = request.getParameter("searchinput");
		String searchselect1 = request.getParameter("searchselect1");
		String searchselect2 = request.getParameter("searchselect2");
		
		if(searchselect1 == null) {
			searchselect1 = "전체게시판";
		}
		if(searchselect2 == null) {
			searchselect2 = "제목+내용";
		}
		SearchService searchservice = SearchService.getInstance();
		List<BoardDTO> list = searchservice.searchBoardTitleAndContent(searchtext, searchselect1, searchselect2);
		request.setAttribute("list", list);
		request.setAttribute("searchtext", searchtext);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/search/searchpage.jsp");
		
		return forward;
	}

}
