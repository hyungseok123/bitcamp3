package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.CategoryDTO;

public class CategoryDAO {
	private static CategoryDAO dao = new CategoryDAO();
	public static CategoryDAO getDAO() {
		return dao;
	}
	private CategoryDAO() {}
	public List<CategoryDTO> getCategoryList(Connection conn) throws SQLException {
		List<CategoryDTO> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select   category_no   ");
		sql.append(" 		, category_name ");
		sql.append(" from category          ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				dto.setCategory_no(rs.getInt("category_no"));
				dto.setCategory_name(rs.getString("category_name"));
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

}
