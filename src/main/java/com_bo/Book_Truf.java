package com_bo;

public class Book_Truf {
	
	private String user_name;
	private String truf_name;
	private String slot_name;
	private String date;
	private String price;
	
	@Override
	public String toString() {
		return "Book_Truf [user_name=" + user_name + ", truf_name=" + truf_name + ", slot_name=" + slot_name + ", date="
				+ date + ", price=" + price + "]";
	}
	public Book_Truf() {
		super();
	}
	public Book_Truf(String user_name, String truf_name, String slot_name, String date, String price) {
		super();
		this.user_name = user_name;
		this.truf_name = truf_name;
		this.slot_name = slot_name;
		this.date = date;
		this.price = price;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTruf_name() {
		return truf_name;
	}
	public void setTruf_name(String truf_name) {
		this.truf_name = truf_name;
	}
	public String getSlot_name() {
		return slot_name;
	}
	public void setSlot_name(String slot_name) {
		this.slot_name = slot_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
