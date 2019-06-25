package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.bitcafe.DAO.MemberDAO;
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
}
