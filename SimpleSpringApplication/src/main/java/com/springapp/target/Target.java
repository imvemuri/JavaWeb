package com.springapp.target;

import java.util.Date;

import javax.validation.constraints.Size;

public class Target {
	
	public Target() {
		super();
	}
	
	private int id;
	private String user;
	private Date date;
	private boolean isDone;
	@Size(min = 5,message="Please enter a min of 5 characters")
	private String desc;
	
	public Target(int count, String user, Date date, boolean isDone, String desc) {
		super();
		this.id = count;
		this.user = user;
		this.date = date;
		this.isDone = isDone;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", date=" + date + ", isDone=" + isDone + ", desc="
				+ desc + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Target other = (Target) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
