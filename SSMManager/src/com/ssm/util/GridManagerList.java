package com.ssm.util;

import java.util.List;

public class GridManagerList<T> {
	private String status;
	private int totals;
	private List<T> data;

	@SuppressWarnings("unused")
	private String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotals() {
		return totals;
	}

	public void setTotals(int totals) {
		this.totals = totals;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
