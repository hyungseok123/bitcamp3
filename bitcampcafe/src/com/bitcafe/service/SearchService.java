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
	public List<BoardDTO> searchBoardTitleAndContent(String searchtext) {
		List<BoardDTO> list = null;
		try(Connection conn = DBConnection.gettb().getConnection()) {
			SearchDAO searchdao = SearchDAO.getInstance();
			list = searchdao.searchBoardTitleAndContent(conn, searchtext);
		} catch(SQLException | NamingException e) {
			System.out.println(e);
		}
		return list;
	}
}
