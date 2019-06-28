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
		if(searchselect2 == null || "제목 내용".equals(searchselect2)) { //선택 기본 설정값 및 글자보정
			searchselect2 = "제목+내용";
		}
		
		SearchService searchservice = SearchService.getInstance();
		int totalcount = searchservice.searchBoardCount(searchtext, searchselect1, searchselect2);
		
		Paging paging = new Paging();
		paging.setCurrpage(currpage);
		paging.setTotalcount(totalcount);
		int totalpage = paging.getTotalpage();
		int startrow = paging.getStartrow();
		int endrow = paging.getEndrow();
		int startblock = paging.getStartblock();
		int endblock = paging.getEndblock();
		int blocksize = paging.getBlocksize();
		
		List<BoardDTO> list = searchservice.searchBoard(searchtext, searchselect1, searchselect2, startrow, endrow);
		if(list != null) {
			if(!"작성자".equals(searchselect2)) {
				for(int i=0; i<list.size(); i++) { //제목 검색부분 재처리 과정
					BoardDTO boarddto = list.get(i);
					String board_title = boarddto.getBoard_title();
					int searchindex = board_title.indexOf(searchtext);
					String board_title_result = board_title.substring(0, searchindex);
					board_title_result += "<span class=\"searchimport\">"+searchtext+"</span>";
					board_title_result += board_title.substring(searchindex+searchtext.length(), board_title.length());
					System.out.println("result : "+board_title_result);
					boarddto.setBoard_title(board_title_result);
				}
			}
			else {
				for(int i=0; i<list.size(); i++) { //작성자 검색부분 재처리 과정
					BoardDTO boarddto = list.get(i);
					String member_nickname = boarddto.getMember_nickname();
					int searchindex = member_nickname.indexOf(searchtext);
					String member_nickname_result = member_nickname.substring(0, searchindex);
					member_nickname_result += "<span class=\"searchimport\">"+searchtext+"</span>";
					member_nickname_result += member_nickname.substring(searchindex+searchtext.length(), member_nickname.length());
					System.out.println("result : "+member_nickname_result);
					boarddto.setMember_nickname(member_nickname_result);
				}
			}
		}
		request.setAttribute("list", list);
		request.setAttribute("searchtext", searchtext);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("blocksize", blocksize);
		request.setAttribute("currpage", currpage);
		request.setAttribute("searchselect1", searchselect1);
		request.setAttribute("searchselect2", searchselect2);
		
		System.out.println("currpage : "+currpage);
		System.out.println("startblock : "+startblock);
		System.out.println("endblock : "+endblock);
		ForwardAction forward = new ForwardAction();
		forward.setRedirect(false);
		forward.setPath("/cafe/search/searchpage.jsp");
		
		return forward;
	}

}
