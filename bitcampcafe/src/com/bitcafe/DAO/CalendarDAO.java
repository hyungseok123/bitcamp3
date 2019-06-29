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

	// db값을 jsonArr 형식으로 받아주기
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
				jsonObject.put("member_no", rs.getInt("member_no"));
				jsonArr.add(jsonObject);
				System.out.println(jsonArr);
			}
		} finally {
			rsClose(rs);
		}
		return jsonArr;
	}

	// 일정 추가
	public int insertList(Connection conn, CalendarDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				" insert into calendar (  calendar_title, calendar_start, calendar_end , calendar_content, calendar_place, calendar_color ,member_no  )");
		sql.append("    values  (    ?  ,  ?  ,  ?  , ?  , ?  ,  ? ,? )        ");
		int result = 0;
		System.out.println("end : " + dto.getCalendar_end());
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, dto.getCalendar_title());
			pstmt.setString(2, dto.getCalendar_start());
			pstmt.setString(3, dto.getCalendar_end());
			pstmt.setString(4, dto.getCalendar_content());
			pstmt.setString(5, dto.getCalendar_place());
			pstmt.setString(6, dto.getCalendar_color());
			pstmt.setInt(7, dto.getMember_no());
			result = pstmt.executeUpdate();
		}
		return result;
	}

	// 일정 디테일 , 작성자 닉네임을 보여주기 위해 member, calendar join
	public CalendarDTO detailList(Connection conn, int no) throws SQLException {
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				"   select   calendar_no, calendar_title, calendar_start, calendar_end, calendar_content,calendar_place,calendar_color,member.member_no,member_nickname       ");
		sql.append(" from calendar join member on calendar.member_no=member.member_no         ");
		sql.append("  where calendar_no  =    ?");

		CalendarDTO dto = new CalendarDTO();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			System.out.println();
			if (rs.next()) {
				dto.setCalendar_no(rs.getInt("calendar_no"));
				dto.setCalendar_title(rs.getString("calendar_title"));
				dto.setCalendar_start(rs.getString("calendar_start"));
				dto.setCalendar_end(rs.getString("calendar_end"));
				dto.setCalendar_content(rs.getString("calendar_content"));
				dto.setCalendar_place(rs.getString("calendar_place"));
				dto.setCalendar_color(rs.getString("calendar_color"));
				dto.setMember_no(rs.getInt("member_no"));
				dto.setMember_nickname(rs.getString("member_nickname"));
			}
		} finally {
			rsClose(rs);
		}
		return dto;
	}

	// 일정 삭제
	public int deleteList(Connection conn, int no) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete   from  calendar     ");
		sql.append("  where calendar_no=  ?       ");
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}
		return result;

	}

	// 일정 수정
	public int modifyList(Connection conn, CalendarDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("    update calendar set          ");
		sql.append("    calendar_title=  ?   ,       ");
		sql.append("    calendar_start=  ?   ,       ");
		sql.append("    calendar_end=    ?   ,       ");
		sql.append("    calendar_content=?   ,       ");
		sql.append("    calendar_place=  ?   ,       ");
		sql.append("    calendar_color=  ?          ");
		sql.append("    where calendar_no= ?         ");
		int result = 0;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, dto.getCalendar_title());
			pstmt.setString(2, dto.getCalendar_start());
			pstmt.setString(3, dto.getCalendar_end());
			pstmt.setString(4, dto.getCalendar_content());
			pstmt.setString(5, dto.getCalendar_place());
			pstmt.setString(6, dto.getCalendar_color());
			pstmt.setInt(7, dto.getCalendar_no());
			result = pstmt.executeUpdate();
		}
		System.out.println("모디 디에이오");
		return result;
	}

}
