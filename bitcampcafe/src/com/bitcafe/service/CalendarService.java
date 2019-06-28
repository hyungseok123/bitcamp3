package com.bitcafe.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.json.simple.JSONArray;

import com.bitcafe.DAO.CalendarDAO;
import com.bitcafe.util.DBConnection;


public class CalendarService {

		private static CalendarService service =new CalendarService();
		
		public static CalendarService getCalendarService() {
			return service;
		}
		
		private CalendarService() {
			
		}
		
		// json으로 list 넘기기
		public JSONArray JsonService() {
			DBConnection db = DBConnection.gettb();
			Connection conn = null;
			JSONArray jsonArr = null;
			try {
				conn = db.getConnection();
				conn.setAutoCommit(false);
				CalendarDAO dao = CalendarDAO.getCalendarDAO();
				jsonArr =dao.getJson(conn);
				conn.commit();
			}catch(SQLException | NamingException | RuntimeException e) {
				System.out.println(e);
				try {
					conn.rollback();
				}catch(SQLException e2) {
					System.out.println(e2);
				}			
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					System.out.println(e);
				}
			}
		}
			return jsonArr;
}
}
