package com.bitcafe.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.BoardDAO;
import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.util.DBConnection;

public class BoardService {

	// singleton pattern으로 작성
	// ListAction에서 부름

	private static BoardService instance = new BoardService();

	public static BoardService getInstance() {
		return instance;
	}

	private BoardService() {
	}

	public List<BoardDTO> BoardListService() {
		Connection conn = null;
		List<BoardDTO> list = null;

		try {

			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = new BoardDAO();
			list = dao.BoardgetList(conn);
			System.out.println("list" + list);
			conn.commit();

		} catch (SQLException | NamingException e) {
			System.out.println(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return list;

	}
	
	
	public void BoardInsertService(String title, String content) {
		Connection conn = null;
		try {
			conn = DBConnection.gettb().getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = new BoardDAO();
			int result = dao.BoardInsertData(conn, title, content);

			conn.commit();

		} catch (SQLException e) {
			System.out.println(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} catch (NamingException e) {
			System.out.println(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} catch (RuntimeException e) {
			System.out.println(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} finally {

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

	}
}
