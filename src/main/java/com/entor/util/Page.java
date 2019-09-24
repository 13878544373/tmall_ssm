package com.entor.util;

import java.util.List;

public class Page<T> {

	/**
	 * 当前页
	 */
	private int sp;
	/**
	 * 总记录数
	 */
	private int total;
	/**
	 * 每页记录数
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private int pageCount;
	/**
	 * 每页显示的数据
	 */
	private List<T> list;
	/**
	 * 查询条件参数
	 */
	private String param;
	
	public Page() {
		
	}
	public Page(String currentPage,int total) {
		this(currentPage, 5, total);
	}
	public Page(String currentPage,int pageSize,int total) {
		this.pageSize = pageSize;
		this.total = total;
		this.pageCount = this.total/this.pageSize;
		if(this.total%this.pageSize!=0) {
			this.pageCount ++;
		}
		try {
			this.sp = Integer.parseInt(currentPage);
		}catch(Exception e) {
			this.sp = 1;
		}
		if(this.sp>this.pageCount) {
			this.sp = this.pageCount;
		}
		if(this.sp<1) {
			this.sp = 1;
		}
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
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
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	@Override
	public String toString() {
		return "Page [sp=" + sp + ", total=" + total + ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", list="
				+ list + ", param=" + param + "]";
	}
	
}
