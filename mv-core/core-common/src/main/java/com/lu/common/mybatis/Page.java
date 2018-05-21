package com.lu.common.mybatis;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 6331390013259356532L;

	private int pageSize = 20;
	private int currentPageNo = 1;
	private int totalRecord;
	@Getter
	@Setter
    private Double statisticCountDouble;//统计值
	@Getter
	@Setter
    private Long statisticCountLong;//统计值
	private List<T> result;
	private T model;

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	/**
	 * 获取总页数
	 * 
	 * @return int
	 */
	public int getTotalPage() {
		int totalPage = 0;
		if (this.getTotalRecord() % this.pageSize == 0) {
			totalPage = this.getTotalRecord() / this.pageSize;
		} else {
			totalPage = this.getTotalRecord() / this.pageSize + 1;
		}
		return totalPage;
	}

	/**
	 * 获取开始行
	 * 
	 * @return int
	 */
	public int getBeginRow() {
		return (this.currentPageNo - 1) * this.pageSize;
	}

	/**
	 * 获取结束行
	 * 
	 * @return
	 */
	public int getEndRow() {
		return this.currentPageNo * this.pageSize;
	}

	/**
	 * 获取最后一页
	 * 
	 * @return
	 */
	public int getLastPageNo() {
		int lastPage = 0;
		if (this.getTotalRecord() % this.pageSize == 0) {
			lastPage = this.getTotalRecord() / this.pageSize;
		} else {
			lastPage = (this.getTotalRecord() / this.pageSize) + 1;
		}
		return lastPage;
	}

	/**
	 * 判断是否有上一页
	 * 
	 * @return
	 */
	public boolean hasPrevPage() {
		return this.currentPageNo > 1;
	}

	/**
	 * 获取上一页
	 * 
	 * @return int
	 */
	public int getPrevPageNo() {
		int prevPageNo = 0;
		if (this.currentPageNo == 1) {
			prevPageNo = this.currentPageNo;
		} else {
			prevPageNo = this.currentPageNo - 1;
		}
		return prevPageNo;
	}

	/**
	 * 判断是否有下一页
	 * 
	 * @return
	 */
	public boolean hasNextPage() {
		return this.currentPageNo < this.getLastPageNo();
	}

	/**
	 * 获取下一页
	 * 
	 * @return
	 */
	public int getNextPageNo() {
		int nextPageNo = 0;
		if (this.currentPageNo == this.getLastPageNo()) {
			nextPageNo = this.currentPageNo;
		} else {
			nextPageNo = this.currentPageNo + 1;
		}
		return nextPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

}
