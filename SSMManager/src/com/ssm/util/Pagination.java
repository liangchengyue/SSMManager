package com.ssm.util;

public class Pagination {
	private int pSize = 10;
	private int cPage = 1;
	private String keyword;
	private int skipNum = 1;// 当前第几条记录开始
	private int takeNum = 10;// 从开始记录开始每页显示条数
	private int userId;
	private int count;
	private int pageCount;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
		this.pSize = pSize;
	}

	public int getcPage() {
		return cPage;
	}

	public void setcPage(int cPage) {
		this.cPage = cPage;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getSkipNum() {
		return (cPage - 1) * pSize;
	}

	public int getTakeNum() {
		return pSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return (int) Math.ceil((float) count / pSize);
	}

	public void setTakeNum(int takeNum) {
		this.takeNum = takeNum;
	}
	
}
