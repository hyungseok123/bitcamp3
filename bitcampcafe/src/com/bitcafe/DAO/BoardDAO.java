package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.BoardDTO;

public class BoardDAO {

	// 싱글톤 사용

	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getDAO() {
		return dao;
	}

	private BoardDAO() {
	}

	// BoardService에 있는 count정보를 받는다
	// connection 얻어 오기
	public int getCount(Connection conn) throws SQLException {
		// 전체 자료의 개수를 얻어오는 메서드
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) from board ");
		int datacount = 0;

		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ResultSet rs = pstmt.executeQuery();) {

			if (rs.next()) {
				datacount = rs.getInt(1);
			}

		}
		return datacount;
	}// getCount
	

	// service에서 getCount 호출함->service로 이동

	public List<BoardDTO> getData(Connection conn, int startrow, int endrow) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		sql.append(" select *                  ");
		sql.append(" from board                ");
		sql.append(" order by board_no        ");
		sql.append(" desc limit ?, ?           ");

		List<BoardDTO> arr = new ArrayList<>();

		try {

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, endrow);
			pstmt.setInt(2, startrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				BoardDTO dto = new BoardDTO();
				dto.setBoardNo(rs.getInt("board_no"));
				dto.setBoardTitle(rs.getString("board_title"));
				dto.setBoardContent(rs.getString("board_content"));
				dto.setBoardWritedate(rs.getDate("board_writedate"));
				dto.setBoardViewcount(rs.getInt("board_viewcount"));
				dto.setBoardFavcount(rs.getInt("board_favcount"));
				dto.setCategoryNo(rs.getInt("category_no"));
				dto.setMemberNo(rs.getInt("member_no"));

				arr.add(dto);

			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}

		return arr;

	}

}
