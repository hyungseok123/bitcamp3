package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.bitcafe.DAO.MemberDAO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.util.DBConnection;

public class MemberService {
	private static MemberService memberservice = new MemberService();
	
	private MemberService() {}
	
	public static MemberService getInstance() {
		return memberservice;
	}
	
	public boolean memberIdOverlapCheck(String member_id) {
		boolean result = false; 
		try(Connection conn = DBConnection.gettb().getConnection();) {
			MemberDAO memberdao = MemberDAO.getInstance();
			result = memberdao.memberIdOverlapCheck(conn, member_id);
		} catch(SQLException | NamingException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public boolean memberNicknameOverlapCheck(String member_nickname) {
		boolean result = false;
		try(Connection conn = DBConnection.gettb().getConnection();) {
			MemberDAO memberdao = MemberDAO.getInstance();
			result = memberdao.memberNicknameOverlapCheck(conn, member_nickname);
		} catch(SQLException | NamingException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public void memberInsert(MemberDTO memberdto) {
		Connection conn = null;
		try {
			conn = DBConnection.gettb().getConnection();
			conn.setAutoCommit(false);
			MemberDAO memberdao = MemberDAO.getInstance();
			memberdao.memberInsert(conn, memberdto);
			conn.commit();
		} catch(SQLException | NamingException e) {
			try { conn.rollback(); } catch(SQLException e1) {}
		} finally {
			closeconn(conn);
		}
	}
	
	public MemberDTO memberLogin(String member_id, String member_pwd) {
		MemberDTO memberdto = null;
		try(Connection conn = DBConnection.gettb().getConnection();) {
			MemberDAO memberdao = MemberDAO.getInstance();
			memberdto = memberdao.memberLogin(conn, member_id, member_pwd);
		} catch(SQLException | NamingException e) {
			System.out.println(e);
		}
		return memberdto;
	}
	
	
	
	private void closeconn(Connection conn) {
		if(conn != null) try {conn.close();} catch(SQLException e) {}
	}
}
