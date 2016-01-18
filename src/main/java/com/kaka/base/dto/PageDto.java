package com.kaka.base.dto;

import java.util.List;

public class PageDto<T> extends BaseDto {

	private static final long serialVersionUID = -7774629409919830220L;

	public PageDto() {
		super();
	}

	public PageDto(int total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	private int total;
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
