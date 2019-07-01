package com.bitcafe.util;

public class Paging {
	//############################################ SET #####################################
	private int currpage;		// 현재 페이지 값 파라미터로 받아오세용
	private int totalcount;	// 모든 값 갯수 DAO에서 불러와서 set하시면 다 밑에 메소드에서 계산해드립니다
	private int totalpage;		// 게시글 얼마나 보여줄건지
	private int blocksize;		// 밑에 블록에서 보여줄 페이지 갯수 입니다
	
	//######################################건들지 마세여###################################
	private int startrow;		// 시작
	private int endrow;		// 끝
	private int startblock;	// 밑에 블록에서 처음으로 시작할 숫자입니다
	private int endblock;		// 밑에 블록에서 끝으로 보여줄 숫자입니다.
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
		this.makePaging();
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getBlocksize() {
		return blocksize;
	}
	public void setBlocksize(int blocksize) {
		this.blocksize = blocksize;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	public int getStartblock() {
		return startblock;
	}
	public void setStartblock(int startblock) {
		this.startblock = startblock;
	}
	public int getEndblock() {
		return endblock;
	}
	public void setEndblock(int endblock) {
		this.endblock = endblock;
	}
	private void makePaging() {
		int pagepercount = 10;
		totalpage = (totalcount / pagepercount) + ((totalcount % pagepercount == 0) ? 0 : 1);	
		startrow = (currpage - 1) * pagepercount + 1;											
		endrow = startrow + pagepercount - 1;													
		if (endrow > totalcount) endrow = totalcount;											
		blocksize = 5;											
		startblock = ((int)((currpage - 1) / (double)blocksize)) * blocksize + 1;
		endblock = startblock + blocksize - 1;
		if (totalpage < endblock) endblock = totalpage;
	}
}
