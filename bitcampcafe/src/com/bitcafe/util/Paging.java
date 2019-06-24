package com.bitcafe.util;

public class Paging {
	private int currpage;		// set ���������� �Ķ���Ͱ� ������ �޾ƿ�
	private int totalcount;	// set dao���� �������� �� �޾ƿ�
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
		totalpage = (totalcount / pagepercount) + ((totalcount % pagepercount == 0) ? 0 : 1);	// 10�� �������� ���������ڰ� ������ �Ǵµ�
		startrow = (currpage - 1) * pagepercount + 1;											// ���� ����
		endrow = startrow + pagepercount - 1;													// �� ����
		if (endrow > totalcount) endrow = totalcount;											// 27���������� ������ 30���� ǥ�õǸ� �ȵǴϱ�..?
		blocksize = 5;																			// 1��� 5�� .. 1���� 5���������� �������� ���
		startblock = ((currpage - 1) / blocksize) * blocksize + 1;
		endblock = startblock + blocksize - 1;
		if (totalpage < endblock) endblock = totalpage;
	}
}
