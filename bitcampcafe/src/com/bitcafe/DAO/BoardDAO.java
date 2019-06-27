package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.BoardDTO;

public class BoardDAO {

	public List<BoardDTO> BoardgetList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		ArrayList<BoardDTO> arr = new ArrayList<>();
		sql.append(" select                           ");
		sql.append("        board_no               	  ");
		sql.append("        ,board_title           	  ");
		sql.append("        ,board_content         	  ");
		sql.append("        ,board_writedate       	  ");
		sql.append("        ,board_viewcount       	  ");
		sql.append("        ,board_favcount        	  ");
		sql.append("        ,c.category_no         	  ");
		sql.append(" 		,c.category_name       	  ");
		sql.append("        ,m.member_no              ");
		sql.append(" 		,m.member_nickname        ");
		sql.append(" from board b join member m       ");
		sql.append(" on b.member_no = m.member_no     ");
		sql.append("              join category c     ");
		sql.append(" on b.category_no = c.category_no ");
		sql.append(" order by board_writedate desc    ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setBoard_no(rs.getInt("board_no"));
				data.setBoard_title(rs.getString("board_title"));
				data.setBoard_writedate(rs.getDate("board_writedate"));
				data.setBoard_content(rs.getString("board_content"));
				data.setBoard_viewcount(rs.getInt("board_viewcount"));
				data.setBoard_favcount(rs.getInt("board_favcount"));
				data.setCategory_no(rs.getInt("category_no"));
				data.setMember_no(rs.getInt("member_no"));
				data.setMember_nickname(rs.getString("member_nickname"));
				data.setCategory_name(rs.getString("category_name"));
				arr.add(data);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return arr;

	}

	public int BoardInsertData(Connection conn, String title, String content) {

		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append(" insert into board               ");
		sql.append("     (board_title , board_content) ");
		sql.append(" values ( ?,? )                  ");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}

	public BoardDTO BoardGetDetail(Connection conn, int board_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO result = new BoardDTO();
		StringBuilder sql = new StringBuilder();
		sql.append(" select                           ");
		sql.append("        board_no               	  ");
		sql.append("        ,board_title           	  ");
		sql.append("        ,board_content         	  ");
		sql.append("        ,board_writedate       	  ");
		sql.append("        ,board_viewcount       	  ");
		sql.append("        ,board_favcount        	  ");
		sql.append("        ,c.category_no         	  ");
		sql.append(" 		,c.category_name       	  ");
		sql.append("        ,m.member_no              ");
		sql.append(" 		,m.member_nickname        ");
		sql.append(" from board b join member m       ");
		sql.append(" on b.member_no = m.member_no     ");
		sql.append("              join category c     ");
		sql.append(" on b.category_no = c.category_no ");
		sql.append(" where board_no = ?               ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.setBoard_no(rs.getInt("board_no"));
				result.setBoard_title(rs.getString("board_title"));
				result.setBoard_writedate(rs.getDate("board_writedate"));
				result.setBoard_content(rs.getString("board_content"));
				result.setBoard_viewcount(rs.getInt("board_viewcount"));
				result.setBoard_favcount(rs.getInt("board_favcount"));
				result.setCategory_no(rs.getInt("category_no"));
				result.setMember_no(rs.getInt("member_no"));
				result.setMember_nickname(rs.getString("member_nickname"));
				result.setCategory_name(rs.getString("category_name"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return result;
	}

}
