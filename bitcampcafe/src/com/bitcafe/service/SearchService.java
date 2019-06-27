package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.SearchDAO;
import com.bitcafe.DTO.BoardDTO;
import com.bitcafe.util.DBConnection;

public class SearchService {
	private static SearchService searchservice = new SearchService();
	
	private SearchService() {}
	
	public static SearchService getInstance() {
		return searchservice;
	}
	
	/**
	 * 제목+내용 검색
	 */
	public List<BoardDTO> searchBoard(String searchtext, String searchselect1, String searchselect2,int startrow,int endrow) {
		List<BoardDTO> list = null;
		try(Connection conn = DBConnection.gettb().getConnection()) {
			SearchDAO searchdao = SearchDAO.getInstance();
			list = searchdao.searchBoard(conn, searchtext, searchselect1, searchselect2, startrow, endrow);
		} catch(SQLException | NamingException e) {
			System.out.println(e);
		}
		return list;
	}
	
	/**
	 * 검색한 총 갯수
	 */
	public int searchBoardCount(String searchtext, String searchselect1, String searchselect2) {
		int result = 0;
		try(Connection conn = DBConnection.gettb().getConnection()) {
			SearchDAO searchdao = SearchDAO.getInstance();
			result = searchdao.searchBoardCount(conn, searchtext, searchselect1, searchselect2);
		} catch(SQLException | NamingException e) {
			System.out.println(e);
		}
		return result;
	}
}
