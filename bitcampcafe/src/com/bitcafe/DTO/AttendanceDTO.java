package com.bitcafe.DTO;

import java.sql.Date;

public class AttendanceDTO {

	private int attendance_no;
	private String attendance_content;
	private Date attendance_writedate;
	private int member_no;
	private String member_nickname;

	public int getAttendance_no() {
		return attendance_no;
	}

	public void setAttendance_no(int attendance_no) {
		this.attendance_no = attendance_no;
	}

	public String getAttendance_content() {
		return attendance_content;
	}

	public void setAttendance_content(String attendance_content) {
		this.attendance_content = attendance_content;
	}

	public Date getAttendance_writedate() {
		return attendance_writedate;
	}

	public void setAttendance_writedate(Date attendance_writedate) {
		this.attendance_writedate = attendance_writedate;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

}
