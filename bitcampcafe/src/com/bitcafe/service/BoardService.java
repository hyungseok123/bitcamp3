package com.bitcafe.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.BoardDAO;
import com.bitcafe.DAO.CommentDAO;
import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.util.DBConnection;

public class BoardService {

	// singleton pattern으로 작성
	// ListAction에서 부름

	private static BoardService instance = new BoardService();
	public static BoardService getInstance() {
		return instance;
	}
	private BoardService() {}

	public List<BoardDTO> BoardListService() {
		Connection conn = null;
		List<BoardDTO> list = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDao();
			list = dao.BoardgetList(conn);
			conn.commit();
		} catch (SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch (SQLException e1) {}
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return list;
	}
	
	public int BoardInsertService(BoardDTO dto) {
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int result = 0;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDao();
			result = dao.BoardInsertData(conn, dto);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try {conn.rollback();} catch (SQLException e1) {}
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return result;
	}
	
	public BoardDTO BoardDetailService(int board_no) {
		Connection conn = null;
		BoardDTO dto = new BoardDTO();
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDao();
			dto = dao.BoardGetDetail(conn, board_no);
			conn.commit();
		} catch (SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch (SQLException e1) {}
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return dto;
	}
	
	
	public int BoardUpdateService(BoardDTO dto) {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDao();
			result = dao.BoardUpdateData(conn, dto);
			conn.commit();
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	public int BoardDeleteData(int board_no) {
		int result = 0;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDao();
			result = dao.BoardDeleteData(conn, board_no);
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
