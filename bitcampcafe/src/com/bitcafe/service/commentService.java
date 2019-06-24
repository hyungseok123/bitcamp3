package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.commentDAO;
import com.bitcafe.DTO.commentDTO;
import com.bitcafe.util.DBConnection;

public class commentService {
	private static commentService service = new commentService();
	public static commentService getService() {
		return service;
	}
	public int getCommentTotalCount() {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			commentDAO dao = commentDAO.getDAO();
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
	public List<commentDTO> getCommentList() {
	    List<commentDTO> result = null;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			commentDAO dao = commentDAO.getDAO();
			result = dao.commentList(conn);
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
