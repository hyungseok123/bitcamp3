package com.bitcafe.util;

public class Paging {
	private int currpage;		// set 페이지에서 파라미터값 보낸거 받아옴
	private int totalcount;	// set dao에서 쿼리돌린 값 받아옴
	private int totalpage;		// 
	private int blocksize;		//
	private int startrow;
	private int endrow;
	private int startblock;
	private int endblock;
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
/*		totalcount = service.getCount();*/
		int pagepercount = 10;
		totalpage = (totalcount / pagepercount) + ((totalcount % pagepercount == 0) ? 0 : 1);	// 10을 기준으로 페이지숫자가 을마나 되는데
		startrow = (currpage - 1) * pagepercount + 1;											// 시작 숫자
		endrow = startrow + pagepercount - 1;													// 끝 숫자
		if (endrow > totalcount) endrow = totalcount;											// 27페이지까지 있을때 30까지 표시되면 안되니까..?
		blocksize = 5;																			// 1블록 5개 .. 1부터 5페이지까지 보여지는 목록
		startblock = ((currpage - 1) / blocksize) * blocksize + 1;
		endblock = startblock + blocksize - 1;
		if (totalpage < endblock) endblock = totalpage;
	}
}
