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
	 * 제목+내용 검색
	 */
	public List<BoardDTO> searchBoardTitleAndContent(Connection conn ,String searchtext) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select board_no, board_title, board_content, board_writedate, board_viewcount, member_nickname");
		sql.append(" from board inner join member ");
		sql.append(" on board.member_no = member.member_no ");
		sql.append(" where board_title like ? or board_content like ? ");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BoardDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+searchtext+"%");
			pstmt.setString(2, "%"+searchtext+"%");
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
	
	private void autoClose(AutoCloseable ac) {
		if(ac != null) try { ac.close(); } catch(Exception e) {}
	}
}
