package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private static MemberDAO memberdao = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return memberdao;
	}
	
	public boolean memberIdOverlapCheck(Connection conn, String member_id) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select member_id from member");
		sql.append(" where member_id = ? ");
		boolean result = false;
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String tmp_member_id = rs.getString(1);
				if(tmp_member_id != null) {
					result = true;
				}
			}
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
		}
		return result;
	}
	
	public boolean memberNicknameOverlapCheck(Connection conn, String member_nickname) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select member_nickname from member");
		sql.append(" where member_nickname = ? ");
		boolean result = false;
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, member_nickname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String tmp_member_nickname = rs.getString(1);
				if(tmp_member_nickname != null) {
					result = true;
				}
			}
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
		}
		return result;
	}
}
