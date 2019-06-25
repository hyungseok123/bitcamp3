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

	// 자료 개수를 얻어오는 메서드
	public int getCount() {

		// db연결 객체정보 얻는다
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int datacount = 0;
		// connection 객체 받기
		try {

			conn = db.getConnection();
			// dao에서 count 객체 받기
			BoardDAO dao = BoardDAO.getDAO();
			datacount = dao.getCount(conn);

		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		// dao에 자료 넘김
		return datacount;
	}

	// ListAction에서 getList메서드를 사용하도록 만듦
	// connection 받고 start 값과 end 값 넘김
	public List<BoardDTO> getList(int startrow, int endrow) {

		// connection 받기
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		List<BoardDTO> list = null;
		try {
			conn = db.getConnection();
			// dao만들어줌
			BoardDAO dao = BoardDAO.getDAO();
			// service에 conn start end 값 넘김
			// return은 list로
			list = dao.getData(conn, startrow, endrow);

		} catch (SQLException | NamingException e) {
			System.out.println(e);
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
		// TODO Auto-generated method stub
		Connection conn = null;
		try {

			conn = DBConnection.gettb().getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDAO();
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
