package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.AttendanceDAO;
import com.bitcafe.DTO.AttendanceDTO;
import com.bitcafe.util.DBConnection;

public class AttendanceService {

	private static AttendanceService service = new AttendanceService();
	public static AttendanceService getService()
	{
		return service;

	}
	private AttendanceService() {}	

	public List<AttendanceDTO> list()
	{
		DBConnection db=DBConnection.gettb();
		Connection conn=null;
		List<AttendanceDTO> list=null;
		try { 
			conn=db.getConnection();
			conn.setAutoCommit(false);
			AttendanceDAO dao = AttendanceDAO.getDAO();
			list = dao.attendanceList(conn,0,0);
			conn.commit();

		}catch(SQLException|NamingException e)
		{
			try {conn.rollback();}catch(SQLException e1) {}
		}finally {
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		return list;


	}

	public int AttendanceInsert(String attendance, int member_no)
	{
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int result=0;
		try{conn = db.getConnection();
		conn.setAutoCommit(false);
		AttendanceDAO dao=AttendanceDAO.getDAO();
		result = dao.AttendanceInsert(conn, attendance,member_no);

		conn.commit();
		}catch(SQLException|NamingException e)
		{
			try { conn.rollback();}catch(SQLException e1) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;

	}



	public int AttendanceDelete(AttendanceDTO dto)
	{
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int result =0;
		try { conn=db.getConnection();
		AttendanceDAO dao = AttendanceDAO.getDAO();
		result = dao.AttendanceDelete(conn, dto);


		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}

		return result;

	}

	public int AttendanceUpdate(AttendanceDTO dto)
	{
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int result=0;
		try{

			conn = db.getConnection();
			AttendanceDAO dao = AttendanceDAO.getDAO();
			result = dao.AttendanceUpdate(conn,dto);

		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}


		return result;


	}








}