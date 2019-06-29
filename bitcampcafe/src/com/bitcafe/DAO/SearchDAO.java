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
	public List<BoardDTO> searchBoard(Connection conn ,String searchtext, String searchselect1, String searchselect2, int startrow, int endrow) throws SQLException {
		StringBuilder sql = new StringBuilder();
		int category_no = searchCategoryNo(conn, searchselect1); //카테고리 번호를 추출
		sql.append(" select  @rownum:=@rownum+1 as rnum, board_no, board_title, board_content, board_writedate, board_viewcount, member_nickname");
		sql.append(" from board inner join member ");
		sql.append(" on board.member_no = member.member_no ");
		sql.append(" where (@rownum:=?)=? ");
		if(searchselect2.equals("작성자")) {//작성자 검색
			sql.append("and member_nickname like ? ");
		}
		else if(searchselect2.equals("제목만")) {//제목만 검색
			sql.append(" and board_title like ? ");
		}
		else {//제목+내용 검색
			sql.append(" and (board_title like ? or board_content like ?) ");
		}
		if(!searchselect1.equals("전체게시판")) //전체게시판이 아니라면!
			sql.append(" and category_no = "+category_no+" ");
		sql.append(" order by board_no desc "); //게시판번호 별로 내림차 정렬
		sql.append(" limit "+(startrow-1)+","+(endrow-startrow+1)+" ");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BoardDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, startrow-1);
			pstmt.setInt(2, startrow-1);
			if(searchselect2.equals("작성자")) {//작성자 검색
				pstmt.setString(3, searchtext);
			}
			else if(searchselect2.equals("제목만")) {//제목만 검색
				pstmt.setString(3, searchtext);
			}
			else {//제목+내용 검색
				pstmt.setString(3, searchtext);
				pstmt.setString(4, searchtext);
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
	
	public int searchBoardCount(Connection conn ,String searchtext, String searchselect1, String searchselect2) throws SQLException {
		StringBuilder sql = new StringBuilder();
		int category_no = searchCategoryNo(conn, searchselect1); //카테고리 번호를 추출
		sql.append(" select count(*) ");
		sql.append(" from board inner join member ");
		sql.append(" on board.member_no = member.member_no ");
		if(searchselect2.equals("작성자")) {//작성자 검색
			sql.append(" where member_nickname like ? ");
		}
		else if(searchselect2.equals("제목만")) {//제목만 검색
			sql.append(" where board_title like ? ");
		}
		else {//제목+내용 검색
			sql.append(" where (board_title like ? or board_content like ?) ");
		}
		if(!searchselect1.equals("전체게시판")) //전체게시판이 아니라면!
			sql.append(" and category_no = "+category_no+" ");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			if(searchselect2.equals("작성자")) {//작성자 검색
				pstmt.setString(1, searchtext);
			}
			else if(searchselect2.equals("제목만")) {//제목만 검색
				pstmt.setString(1, searchtext);
			}
			else {//제목+내용 검색
				pstmt.setString(1, searchtext);
				pstmt.setString(2, searchtext);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			} 
		} finally {
			autoClose(rs);
			autoClose(pstmt);
		}
		return result;
	}
	
	private void autoClose(AutoCloseable ac) {
		if(ac != null) try { ac.close(); } catch(Exception e) {}
	}
}
