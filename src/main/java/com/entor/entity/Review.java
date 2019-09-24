package com.entor.entity;

import java.sql.Timestamp;

public class Review {
	private int id;
	private String content;
	private int uid;
	private int pid;
	private Timestamp createdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", uid=" + uid + ", pid=" + pid + ", createdate="
				+ createdate + "]";
	}
	
}
