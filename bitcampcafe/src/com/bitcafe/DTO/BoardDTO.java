package com.bitcafe.DTO;

import java.sql.Date;

public class BoardDTO {

	private int board_no;
	private String board_title;
	private String board_content;
	private Date board_writedate;
	private int board_viewcount;
	private int board_favcount;
	private int category_no;
	private int member_no;
	private String member_nickname;
	
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(int board_no, String board_title, String board_content, Date board_writedate, int board_viewcount,
			int board_favcount, int category_no, int member_no, String member_nickname) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_writedate = board_writedate;
		this.board_viewcount = board_viewcount;
		this.board_favcount = board_favcount;
		this.category_no = category_no;
		this.member_no = member_no;
		this.member_nickname = member_nickname;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_writedate() {
		return board_writedate;
	}
	public void setBoard_writedate(Date board_writedate) {
		this.board_writedate = board_writedate;
	}
	public int getBoard_viewcount() {
		return board_viewcount;
	}
	public void setBoard_viewcount(int board_viewcount) {
		this.board_viewcount = board_viewcount;
	}
	public int getBoard_favcount() {
		return board_favcount;
	}
	public void setBoard_favcount(int board_favcount) {
		this.board_favcount = board_favcount;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
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
