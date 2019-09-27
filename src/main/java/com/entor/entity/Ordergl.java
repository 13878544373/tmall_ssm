package com.entor.entity;

import java.sql.Timestamp;

public class Ordergl {

	private int id;
	private String status;
	private Timestamp createDate;
	private Timestamp payDate;
	private Timestamp deliveryDate;
	private Timestamp confirmDate;
	private int pid;
	private String pname;
	private String uname;
	private float promotePrice;
	private int number;
	/**
	 * 以下需要计算
	 */
	private int piid;
	private String statusDesc;
	private float total;
	private int totalNumber;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public float getPromotePrice() {
		return promotePrice;
	}
	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Timestamp getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(Timestamp confirmDate) {
		this.confirmDate = confirmDate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getPiid() {
		return piid;
	}
	public void setPiid(int piid) {
		this.piid = piid;
	}
	@Override
	public String toString() {
		return "Ordergl [id=" + id + ", status=" + status + ", createDate=" + createDate + ", payDate=" + payDate
				+ ", deliveryDate=" + deliveryDate + ", confirmDate=" + confirmDate + ", pid=" + pid + ", pname="
				+ pname + ", uname=" + uname + ", promotePrice=" + promotePrice + ", number=" + number + ", piid="
				+ piid + ", statusDesc=" + statusDesc + ", total=" + total + ", totalNumber=" + totalNumber + "]";
	}
	
}
