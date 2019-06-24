package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.commentDTO;
import com.mysql.cj.protocol.Resultset;

public class commentDAO {
	private static commentDAO dao = new commentDAO();
	public static commentDAO getDAO() {
		return dao;
	}
	public int commentTotalCount(Connection conn) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) ");
		sql.append(" from comment    ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) result = rs.getInt(1);
		} catch (SQLException e) {
			throw e;
		} finally {
	    	if(pstmt!=null) try{ conn.close();} catch(SQLException e){}
	    	if(rs!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public List<commentDTO> commentList(Connection conn) throws SQLException {
		List<commentDTO> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select   comment_no             ");
		sql.append(" 		, comment_content        ");
		sql.append(" 		, comment_writedate      ");
		sql.append(" 		, comment_parent         ");
		sql.append(" 		, comment_depth          ");
		sql.append(" 		, comment_order          ");
		sql.append(" 		, board_no               ");
		sql.append(" 		, member_no              ");
		sql.append(" from comment                    ");
		sql.append(" order by comment_writedate desc ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				commentDTO dto = new commentDTO();
				dto.setComment_no(rs.getInt("comment_no"));
				dto.setComment_content(rs.getString("comment_content"));
				dto.setComment_writedate(rs.getDate("comment_writedate"));
				dto.setComment_parent(rs.getInt("comment_parent"));
				dto.setComment_depth(rs.getInt("comment_depth"));
				dto.setComment_order(rs.getInt("comment_order"));
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setMember_no(rs.getInt("member_no"));
				result.add(dto);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
	    	if(pstmt!=null) try{ conn.close();} catch(SQLException e){}
	    	if(rs!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
}
