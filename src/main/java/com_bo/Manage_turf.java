package com_bo;

public class Manage_turf {
	private String no;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	private String name;
	private String time;
	private String price;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Manage_turf(String no, String name, String time, String price, String status) {
		super();
		this.no = no;
		this.name = name;
		this.time = time;
		this.price = price;
		this.status = status;
	}
	public Manage_turf() {
		super();
	}
	@Override
	public String toString() {
		return "Manage_turf [no=" + no + ", name=" + name + ", time=" + time + ", price=" + price + ", status=" + status
				+ "]";
	}
	
	
	
	

}
