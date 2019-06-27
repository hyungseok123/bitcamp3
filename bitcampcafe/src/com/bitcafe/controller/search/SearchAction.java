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
		String searchcselect1 = request.getParameter("searchcselect1");
		String searchcselect2 = request.getParameter("searchcselect2");
		
		SearchService searchservice = SearchService.getInstance();
		List<BoardDTO> list = searchservice.searchBoardTitleAndContent(searchtext);
		request.setAttribute("list", list);
		request.setAttribute("searchtext", searchtext);
		
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/search/searchpage.jsp");
		
		return forward;
	}

}
