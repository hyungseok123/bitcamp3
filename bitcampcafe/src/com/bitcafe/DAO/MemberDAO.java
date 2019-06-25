package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitcafe.DTO.MemberDTO;

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
	
	public void memberInsert(Connection conn, MemberDTO memberdto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into member(member_id, member_nickname, member_pwd, member_joindate) ");
		sql.append(" values(?, ?, ?, now() ) ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, memberdto.getMember_id());
			pstmt.setString(2, memberdto.getMember_nickname());
			pstmt.setString(3, memberdto.getMember_pwd());
			pstmt.executeUpdate();
		}
	}
	
	public MemberDTO memberLogin(Connection conn, String member_id, String member_pwd) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select member_no, member_nickname, member_joindate from member ");
		sql.append(" where member_id = ? and member_pwd = ? ");
		ResultSet rs = null;
		MemberDTO memberdto = new MemberDTO();
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberdto.setMember_no(rs.getInt("member_no"));
				memberdto.setMember_nickname(rs.getString("member_nickname"));
				memberdto.setMember_joindate(rs.getDate("member_joindate"));
			}
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
		}
		return memberdto;
	}
}
