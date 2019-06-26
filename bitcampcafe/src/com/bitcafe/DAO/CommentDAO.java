package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.CommentDTO;


public class CommentDAO {
	private static CommentDAO dao = new CommentDAO();
	public static CommentDAO getDAO() {
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
			if(rs!=null) try{ rs.close();} catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}
		return result;
	}
	public List<CommentDTO> commentList(Connection conn) throws SQLException {
		List<CommentDTO> result = new ArrayList<>();
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
		sql.append(" 		, m.member_no            ");
		sql.append(" 		, m.member_nickname      ");
		sql.append(" from comment c join member m    ");
		sql.append(" on c.member_no = m.member_no    ");
		sql.append(" order by comment_parent asc     ");
		sql.append(" 		, comment_order asc      ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setComment_no(rs.getInt("comment_no"));
				dto.setComment_content(rs.getString("comment_content"));
				dto.setComment_writedate(rs.getDate("comment_writedate"));
				dto.setComment_parent(rs.getInt("comment_parent"));
				dto.setComment_depth(rs.getInt("comment_depth"));
				dto.setComment_order(rs.getInt("comment_order"));
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setMember_no(rs.getInt("member_no"));
				dto.setMember_nickname(rs.getString("member_nickname"));
				result.add(dto);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if(rs!=null) try{ rs.close();} catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}
		return result;
	}
	public int commentInsert(Connection conn, CommentDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into comment( comment_content, comment_writedate, comment_parent  ");
		sql.append(" 					, comment_depth, comment_order, board_no, member_no ) ");
		sql.append(" value( ?, now(), ?, ?, ?, ?, ? )                                         ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getComment_content());
			pstmt.setInt(2, dto.getComment_parent());
			pstmt.setInt(3, dto.getComment_depth());
			pstmt.setInt(4, dto.getComment_order());
			pstmt.setInt(5, dto.getBoard_no());
			pstmt.setInt(6, dto.getMember_no());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		} 
		return result;
	}
	public int commentMaxParent(Connection conn) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select max(comment_parent) from comment ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		} catch(SQLException e) {
			throw e;
		} finally {
			if(rs!=null) try{ rs.close();} catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		} 
		return result;
	}
	public int commentMaxOrder(Connection conn, int parentOrder) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select max(comment_order) from comment ");
		sql.append(" where comment_parent = ?               ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, parentOrder);
			rs = pstmt.executeQuery();
			if (rs.next()) result = rs.getInt(1);
		} catch(SQLException e) {
			throw e;
		} finally {
			if(rs!=null) try{ rs.close();} catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
	public int commentDelete(Connection conn, int comment_no) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from comment  ");
		sql.append(" where comment_no = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, comment_no);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
	public CommentDTO commentDetail(Connection conn, int comment_no) throws SQLException {
		CommentDTO result = new CommentDTO();
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
		sql.append(" 		, m.member_no            ");
		sql.append(" 		, m.member_nickname      ");
		sql.append(" from comment c join member m    ");
		sql.append(" on c.member_no = m.member_no    ");
		sql.append(" where comment_no = ?            ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, comment_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.setComment_no(rs.getInt("comment_no"));
				result.setComment_content(rs.getString("comment_content"));
				result.setComment_writedate(rs.getDate("comment_writedate"));
				result.setComment_parent(rs.getInt("comment_parent"));
				result.setComment_depth(rs.getInt("comment_depth"));
				result.setComment_order(rs.getInt("comment_order"));
				result.setBoard_no(rs.getInt("board_no"));
				result.setMember_no(rs.getInt("member_no"));
				result.setMember_nickname(rs.getString("member_nickname"));
			}
		} catch(SQLException e) {
			throw e;
		} finally {
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
	public int commentUpdating(Connection conn, int comment_no, String content) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" update comment          ");
		sql.append(" set comment_content = ? ");
		sql.append(" where comment_no = ?    ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, content);
			pstmt.setInt(2, comment_no);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
}