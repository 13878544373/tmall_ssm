package com.entor.entity;

public class ProValPro {

	private int id;
	private int pid;
	private int ptid;
	private String name;
	private String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ProValPro [id=" + id + ", pid=" + pid + ", ptid=" + ptid + ", name=" + name + ", value=" + value + "]";
	}
	
}
