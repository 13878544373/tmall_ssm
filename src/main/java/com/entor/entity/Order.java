package com.entor.entity;

import java.sql.Timestamp;

public class Order {
	private int id;
	private String ordercode;
	private String address;
	private String post;
	private String receiver;
	private String mobile;
	private String usermessage;
	private Timestamp createdate;
	private Timestamp paydate;
	private Timestamp deliverydate;
	public Timestamp getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(Timestamp deliverydate) {
		this.deliverydate = deliverydate;
	}
	public Timestamp getConfirmdate() {
		return confirmdate;
	}
	public void setConfirmdate(Timestamp confirmdate) {
		this.confirmdate = confirmdate;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private Timestamp confirmdate;
	private int uid;
	private String status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsermessage() {
		return usermessage;
	}
	public void setUsermessage(String usermessage) {
		this.usermessage = usermessage;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public Timestamp getPaydate() {
		return paydate;
	}
	public void setPaydate(Timestamp paydate) {
		this.paydate = paydate;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", ordercode=" + ordercode + ", address=" + address + ", post=" + post
				+ ", receiver=" + receiver + ", mobile=" + mobile + ", usermessage=" + usermessage + ", createdate="
				+ createdate + ", paydate=" + paydate + ", deliverydate=" + deliverydate + ", confirmdate="
				+ confirmdate + ", uid=" + uid + ", status=" + status + "]";
	}
	
}
