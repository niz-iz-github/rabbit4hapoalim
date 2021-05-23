package com.niz.rabbit;

public class Account {
	
	private String name;
	private int id;
	private String phone;
	private int credit;
	
	public Account(String name, int id, String phone, int credit) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.credit = credit;
	}
	
	public Account() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(System.lineSeparator());
		sb.append("name=").append(this.name).append(System.lineSeparator());
		sb.append("id=").append(this.id).append(System.lineSeparator());
		sb.append("phone=").append(this.phone).append(System.lineSeparator());
		sb.append("credit=").append(this.credit).append(System.lineSeparator());
		sb.append("]");
		
		return sb.toString();
	}
}
