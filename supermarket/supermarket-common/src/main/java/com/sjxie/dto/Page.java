package com.sjxie.dto;

public class Page {
	int pageNum;
	int pageSize;
	int pageCount;
	int dataCount;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public Page() {
		super();
	}
	public Page(int pageNum, int pageSize, int pageCount, int dataCount) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
	}
	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", dataCount="
				+ dataCount + "]";
	}

	
	
}
