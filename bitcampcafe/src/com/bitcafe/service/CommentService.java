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
	public int commentTotalCount() {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentTotalCount(conn);
			conn.commit();
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public List<CommentDTO> commentList() {
	    List<CommentDTO> result = null;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			CommentDAO dao = CommentDAO.getDAO();
			result = dao.commentList(conn);
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	public int commentInsert() {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CommentDAO dao = CommentDAO.getDAO();
/*			result = dao.commentInsert(conn);*/
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
