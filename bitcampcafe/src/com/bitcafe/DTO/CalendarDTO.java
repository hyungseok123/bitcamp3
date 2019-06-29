package com.bitcafe.DTO;

public class CalendarDTO {
	private int calendar_no;
	private String calendar_title;
	private String calendar_place;
	private String calendar_content;
	private String calendar_start;
	private String calendar_end;
	private String calendar_color;
	private int member_no;
	private String member_nickname;

	public CalendarDTO(int calendar_no, String calendar_title, String calendar_place, String calendar_content,
			String calendar_start, String calendar_end, String calendar_color, int member_no, String member_nickname) {
		super();
		this.calendar_no = calendar_no;
		this.calendar_title = calendar_title;
		this.calendar_place = calendar_place;
		this.calendar_content = calendar_content;
		this.calendar_start = calendar_start;
		this.calendar_end = calendar_end;
		this.calendar_color = calendar_color;
		this.member_no = member_no;
		this.member_nickname = member_nickname;
	}

	public CalendarDTO() {
		super();
	}

	public int getCalendar_no() {
		return calendar_no;
	}

	public void setCalendar_no(int calendar_no) {
		this.calendar_no = calendar_no;
	}

	public String getCalendar_title() {
		return calendar_title;
	}

	public void setCalendar_title(String calendar_title) {
		this.calendar_title = calendar_title;
	}

	public String getCalendar_place() {
		return calendar_place;
	}

	public void setCalendar_place(String calendar_place) {
		this.calendar_place = calendar_place;
	}

	public String getCalendar_content() {
		return calendar_content;
	}

	public void setCalendar_content(String calendar_content) {
		this.calendar_content = calendar_content;
	}

	public String getCalendar_start() {
		return calendar_start;
	}

	public void setCalendar_start(String calendar_start) {
		this.calendar_start = calendar_start;
	}

	public String getCalendar_end() {
		return calendar_end;
	}

	public void setCalendar_end(String calendar_end) {
		this.calendar_end = calendar_end;
	}

	public String getCalendar_color() {
		return calendar_color;
	}

	public void setCalendar_color(String calendar_color) {
		this.calendar_color = calendar_color;
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
