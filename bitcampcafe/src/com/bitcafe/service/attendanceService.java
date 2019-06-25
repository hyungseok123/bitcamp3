package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcafe.DAO.attendanceDAO;
import com.bitcafe.DTO.attendanceDTO;
import com.bitcafe.util.DBConnection;

public class attendanceService {

	private static attendanceService service = new attendanceService();
	public static attendanceService getService()
	{
		return service;

	}
	private attendanceService() {}	

	public List<attendanceDTO> list()
	{
		DBConnection db=DBConnection.gettb();
		Connection conn=null;
		List<attendanceDTO> list=null;
		try { 
			conn=db.getConnection();
			conn.setAutoCommit(false);
			attendanceDAO dao = attendanceDAO.getDAO();
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

	public int AttendanceInsert(attendanceDTO dto)
	{
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int result=0;
		try{conn = db.getConnection();
		conn.setAutoCommit(false);
		attendanceDAO dao=attendanceDAO.getDAO();
		dao.AttendanceInsert(conn, dto);

		conn.commit();
		}catch(SQLException|NamingException e)
		{
			try { conn.rollback();}catch(SQLException e1) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;

	}



	public int AttendanceDelete(int no)
	{
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int result =0;
		try { conn=db.getConnection();
		attendanceDAO dao = attendanceDAO.getDAO();
		result = dao.AttendanceDelete(conn, no);


		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}

		return result;

	}

	public int AttendanceUpdate(attendanceDTO dto)
	{
		DBConnection db = DBConnection.gettb();
		Connection conn = null;
		int result=0;
		try{

			conn = db.getConnection();
			attendanceDAO dao = attendanceDAO.getDAO();
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
