package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bitcafe.DTO.CalendarDTO;

public class CalendarDAO {

	private static CalendarDAO dao = new CalendarDAO();

	public static CalendarDAO getCalendarDAO() {
		return dao;
	}

	private CalendarDAO() {

	}

	private void rsClose(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	// db값을 jsonArr로 저장
	public JSONArray getJson(Connection conn) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select      *       ");
		sql.append(" from    calendar    ");
		JSONArray jsonArr = new JSONArray();
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("calendar_no", rs.getInt("calendar_no"));
				jsonObject.put("calendar_title", rs.getString("calendar_title"));
				jsonObject.put("calendar_content", rs.getString("calendar_content"));
				jsonObject.put("calendar_place", rs.getString("calendar_place"));
				jsonObject.put("calendar_color", rs.getString("calendar_color"));
				jsonObject.put("calendar_start", rs.getString("calendar_start"));
				jsonObject.put("calendar_end", rs.getString("calendar_end"));
				jsonArr.add(jsonObject);
				System.out.println(jsonArr);
			}
		} finally {
			rsClose(rs);
		}
		return jsonArr;
	}

	public int insertList(Connection conn, CalendarDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				" insert into calendar (  calendar_title, calendar_start, calendar_end , calendar_content, calendar_place, calendar_color   )");
		sql.append("    values  (    ?    ,    ?      ,     ?   , ?   , ?   , ? )        ");
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, dto.getCalendar_title());
			pstmt.setString(2, dto.getCalendar_start());
			pstmt.setString(3, dto.getCalendar_end());
			pstmt.setString(4, dto.getCalendar_content());
			pstmt.setString(5, dto.getCalendar_place());
			pstmt.setString(6, dto.getCalendar_color());
			result = pstmt.executeUpdate();
		}
		return result;
	}

}
