package com_bo;

public class Truf {
	private String id;
	
	private String name;
	private String location;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Truf(String id, String name, String location, String description) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.description = description;
	}
	public Truf() {
		super();
	}
	@Override
	public String toString() {
		return "Truf [id=" + id + ", name=" + name + ", location=" + location + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	

}
