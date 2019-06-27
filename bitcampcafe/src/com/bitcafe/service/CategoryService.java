package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.CategoryDAO;
import com.bitcafe.DTO.CategoryDTO;
import com.bitcafe.util.DBConnection;

public class CategoryService {
	private static CategoryService service = new CategoryService();
	public static CategoryService getService() {
		return service;
	}
	private CategoryService() {}
	public List<CategoryDTO> categoryList() {
	    List<CategoryDTO> result = null;
		Connection conn = null;
		try {
			DBConnection db = DBConnection.gettb();
			conn = db.getConnection();
			CategoryDAO dao = CategoryDAO.getDAO();
			result = dao.getCategoryList(conn);
		} catch(SQLException| NamingException e) {
			System.out.println(e);
			try{ conn.rollback();} catch(SQLException e1){}
		} finally {
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
		return result;
	}
}
