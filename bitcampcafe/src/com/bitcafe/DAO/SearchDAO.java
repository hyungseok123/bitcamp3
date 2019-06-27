package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.BoardDTO;

public class SearchDAO {
	private static SearchDAO searchdao = new SearchDAO();
	
	private SearchDAO() {}
	
	public static SearchDAO getInstance() {
		return searchdao;
	}
	
	/**
	 * 통합 검색
	 */
	public List<BoardDTO> searchBoardTitleAndContent(Connection conn ,String searchtext, String searchselect1, String searchselect2) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select board_no, board_title, board_content, board_writedate, board_viewcount, member_nickname");
		sql.append(" from board inner join member ");
		sql.append(" on board.member_no = member.member_no ");
		if(searchselect2.equals("작성자")) //작성자 검색
			sql.append(" where member_nickname like ? ");
		else if(searchselect2.equals("제목만")) //제목만 검색
			sql.append(" where board_title like ? ");
		else //제목+내용 검색
			sql.append(" where (board_title like ? or board_content like ?) ");
		if(!searchselect1.equals("전체게시판")) //전체게시판이 아니라면!
			sql.append(" and category_no = ? ");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BoardDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+searchtext+"%"); //작성자, 제목만 검색할때
			if(searchselect2.equals("제목+내용")) //제목+내용 검색할때
				pstmt.setString(2, "%"+searchtext+"%");
			
			if(!searchselect1.equals("전체게시판")) { //전체게시판이 아니라면
				int category_no = searchCategoryNo(conn, searchselect1); //카테고리 번호를 추출
				int num = 2;
				if(searchselect2.equals("제목+내용")) //제목+내용을 검색했다면
					num = 3;
				pstmt.setInt(num, category_no);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO boarddto = new BoardDTO();
				boarddto.setBoard_no(rs.getInt("board_no"));
				boarddto.setBoard_title(rs.getString("board_title"));
				boarddto.setBoard_content(rs.getString("board_content"));
				boarddto.setBoard_writedate(rs.getDate("board_writedate"));
				boarddto.setBoard_viewcount(rs.getInt("board_viewcount"));
				boarddto.setMember_nickname(rs.getString("member_nickname"));
				list.add(boarddto);
			} 
		} finally {
			autoClose(rs);
			autoClose(pstmt);
		}
		return list;
	}
	
	/**
	 * 카테고리 이름으로 번호찾기
	 */
	private int searchCategoryNo(Connection conn,String category_name) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select category_no from category ");
		sql.append(" where category_name = ? ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int category_no = -1;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, category_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				category_no = rs.getInt("category_no");
			}
		} finally {
			autoClose(rs);
			autoClose(pstmt);
		}
		return category_no;
	}
	
	private void autoClose(AutoCloseable ac) {
		if(ac != null) try { ac.close(); } catch(Exception e) {}
	}
}
