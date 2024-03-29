package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.CommentDAO;
import com.bitcafe.DTO.CommentDTO;
import com.bitcafe.util.DBConnection;

public class CommentService {
	private static CommentService service = new CommentService();
	public static CommentService getService() {
		return service;
	}
	private CommentService() {}
	public int commentTotalCount(int board_no) {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentTotalCount(conn, board_no);
			conn.commit();
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public List<CommentDTO> commentList(int board_no) {
	    List<CommentDTO> result = null;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentList(conn, board_no);
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public int commentInsert(CommentDTO dto) {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentInsert(conn, dto);
			conn.commit();
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public int getMaxParent() {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentMaxParent(conn);
		} catch(SQLException| NamingException e) {
			System.out.println(e);
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public int getMaxOrder(int parentOrder) {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentMaxOrder(conn, parentOrder);
		} catch(SQLException| NamingException e) {
			System.out.println(e);
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public int commentDelete(int comment_no) {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentDelete(conn, comment_no);
			conn.commit();
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public CommentDTO getCommentDetail(int comment_no) {
		CommentDTO result = new CommentDTO();
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentDetail(conn, comment_no);
			conn.commit();
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public int commentUpdate(int comment_no, String content) {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentUpdating(conn, comment_no, content);
			conn.commit();
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
}
