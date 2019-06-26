package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitcafe.DTO.MemberDTO;
import com.mysql.cj.protocol.Resultset;

public class MemberDAO {
	private static MemberDAO memberdao = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return memberdao;
	}
	
	public boolean memberIdOverlapCheck(Connection conn, String member_id, int session_member_no) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select member_id from member");
		sql.append(" where member_id = ? ");
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String tmp_member_id = rs.getString(1);
				String tmp2_member_id = memberIdSearch(conn, session_member_no);
				if(tmp_member_id != null && tmp_member_id.equals(tmp2_member_id)) {
					result = false;
				}
				else {
					result = true;
				}
			}
		} finally {
			autoClose(rs);
			autoClose(pstmt);
		}
		return result;
	}
	
	public boolean memberNicknameOverlapCheck(Connection conn, String member_nickname, String session_member_nickname) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select member_nickname from member");
		sql.append(" where member_nickname = ? ");
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_nickname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String tmp_member_nickname = rs.getString(1);
				if(tmp_member_nickname != null && tmp_member_nickname.equals(session_member_nickname)) {
						result = false;
				}
				else {
					result = true;
				}
			}
		} finally {
			autoClose(rs);
			autoClose(pstmt);
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
		PreparedStatement pstmt = null;
		MemberDTO memberdto = new MemberDTO();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberdto.setMember_no(rs.getInt("member_no"));
				memberdto.setMember_nickname(rs.getString("member_nickname"));
				memberdto.setMember_joindate(rs.getDate("member_joindate"));
			}
		} finally {
			autoClose(rs);
			autoClose(pstmt);
		}
		return memberdto;
	}
	
	public MemberDTO memberDetail(Connection conn, int member_no) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select member_id, member_nickname ");
		sql.append(" from member ");
		sql.append(" where member_no = ? ");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		MemberDTO memberdto = new MemberDTO();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberdto.setMember_no(member_no);
				memberdto.setMember_id(rs.getString("member_id"));
				memberdto.setMember_nickname(rs.getString("member_nickname"));
			}
		} finally {
			autoClose(rs);
			autoClose(pstmt);
		}
		return memberdto;
	}
	
	public void memberUpdate(Connection conn, MemberDTO memberdto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" update member set");
		sql.append(" member_id = ? ");
		sql.append(" ,member_pwd = ? ");
		sql.append(" ,member_nickname = ? ");
		sql.append(" where member_no = ? ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, memberdto.getMember_id());
			pstmt.setString(2, memberdto.getMember_pwd());
			pstmt.setString(3, memberdto.getMember_nickname());
			pstmt.setInt(4, memberdto.getMember_no());
			pstmt.executeUpdate();
		}
	}
	
	private String memberIdSearch(Connection conn,int member_no) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select member_id from member ");
		sql.append(" where member_no = ? ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String member_id = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member_id = rs.getString("member_id");
			}
		} finally {
			autoClose(rs);
			autoClose(pstmt);
		}
		return member_id; 
	}
	
 	private void autoClose(AutoCloseable ac) {
		if(ac != null) try { ac.close(); } catch(Exception e) {}
	}
}
