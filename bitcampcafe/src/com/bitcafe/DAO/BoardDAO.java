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

		sql.append(" select                   ");
		sql.append("        board_no           ");
		sql.append("        ,board_title       ");
		sql.append("        ,board_content     ");
		sql.append("        ,board_writedate  ");
		sql.append("        ,board_viewcount   ");
		sql.append("        ,board_favcount    ");
		sql.append("        ,category_no        ");
		sql.append("        ,member_no          ");
		sql.append(" from  board          ");

		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setBoardNo(rs.getInt("board_no"));
				data.setBoardTitle(rs.getString("board_title"));
				data.setBoardContent(rs.getString("board_content"));
				data.setBoardViewcount(rs.getInt("board_viewcount"));
				data.setBoardFavcount(rs.getInt("board_favcount"));
				data.setCategoryNo(rs.getInt("category_no"));
				data.setMemberNo(rs.getInt("member_no"));
				arr.add(data);
			}

		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return arr;

	}
}
