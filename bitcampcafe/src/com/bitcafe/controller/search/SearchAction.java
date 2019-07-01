package com.bitcafe.controller.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.BoardService;
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
		String searchselect3 = request.getParameter("searchselect3");
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
		if(searchselect3 == null) { //보기 기본값
			searchselect3 = "제목만 보기";
		}
		
		SearchService searchservice = SearchService.getInstance();
		int totalcount = searchservice.searchBoardCount(searchtext, searchselect1, searchselect2);
		//페이징 계산 시작
		Paging paging = new Paging();
		paging.setCurrpage(currpage);
		paging.setTotalcount(totalcount);
		int totalpage = paging.getTotalpage();
		int startrow = paging.getStartrow();
		int endrow = paging.getEndrow();
		int startblock = paging.getStartblock();
		int endblock = paging.getEndblock();
		int blocksize = paging.getBlocksize();
		//페이징 계산 끝
		
		List<BoardDTO> list = searchservice.searchBoard(searchtext, searchselect1, searchselect2, startrow, endrow);
		if(list != null) {
			if("제목만".equals(searchselect2)) {
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
			else if("작성자".equals(searchselect2)){
				for(int i=0; i<list.size(); i++) { //작성자 검색부분 재처리 과정
					BoardDTO boarddto = list.get(i);
					String member_nickname = boarddto.getMember_nickname();
					int searchindex = member_nickname.indexOf(searchtext);
					String member_nickname_result = member_nickname.substring(0, searchindex);
					member_nickname_result += "<span class=\"searchimport\">"+searchtext+"</span>";
					member_nickname_result += member_nickname.substring(searchindex+searchtext.length(), member_nickname.length());
					boarddto.setMember_nickname(member_nickname_result);
				}
			}
			else {
				for(int i=0; i<list.size(); i++) { //제목+내용 검색부분 재처리 과정
					BoardDTO boarddto = list.get(i);
					String board_title = boarddto.getBoard_title();
					int searchindex = board_title.indexOf(searchtext);
					if(searchindex >0) {
						String board_title_result = board_title.substring(0, searchindex);
						board_title_result += "<span class=\"searchimport\">"+searchtext+"</span>";
						board_title_result += board_title.substring(searchindex+searchtext.length(), board_title.length());
						boarddto.setBoard_title(board_title_result);
					}
					
					String board_content = boarddto.getBoard_content();
					int searchindex2 = board_content.indexOf(searchtext);
					if(searchindex2 >0) {
						String board_content_result = board_content.substring(0, searchindex2);
						board_content_result += "<span class=\"searchimport\">"+searchtext+"</span>";
						board_content_result += board_content.substring(searchindex2+searchtext.length(), board_content.length());
						boarddto.setBoard_content(board_content_result);
					}
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
		request.setAttribute("searchselect3", searchselect3);
		request.setAttribute("null2", "[]"); // []를 위해서 만듬(jstl은 오류로인식함)
		
		//나의 활동페이지 갱신 시작
		HttpSession session = request.getSession();
		MemberDTO memberdto = (MemberDTO)session.getAttribute("memberInfo");
		ForwardAction forward = new ForwardAction();
		if (memberdto == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			int member_no = memberdto.getMember_no();
			BoardService service = BoardService.getInstance();
			int myboard = service.getMyboard(member_no);
			int mycomment = service.getMyComment(member_no);
			request.setAttribute("myboard", myboard);
			request.setAttribute("mycomment", mycomment);
			//나의 활동페이지 갱신 끝
		
			forward.setRedirect(false);
			forward.setPath("/cafe/template/main.jsp?page=/cafe/search/searchpage.jsp");
		}
		return forward;
	}
}
