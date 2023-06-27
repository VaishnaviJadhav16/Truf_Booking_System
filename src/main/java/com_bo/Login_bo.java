package com_bo;

public class Login_bo {
	
	private String name;
	private String email;
	private int password;
	private String phoneNo;
	private String address;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Login_bo(String name, String email, int password, String phoneNo, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	public Login_bo() {
		super();
	}
	@Override
	public String toString() {
		return "Login_bo [name=" + name + ", email=" + email + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", address=" + address + "]";
	}
	
	
	

}
