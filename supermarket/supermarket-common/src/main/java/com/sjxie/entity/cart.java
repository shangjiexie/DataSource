package com.sjxie.entity;

public class cart {
	private String resource_id;
	private String user_id;
	private int status;
	private int counts;
	private String resource_type_id;
	private String resource_type_name;
	private String resource_dec;
	private String resource_price;
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getResource_type_id() {
		return resource_type_id;
	}
	public void setResource_type_id(String resource_type_id) {
		this.resource_type_id = resource_type_id;
	}
	public String getResource_type_name() {
		return resource_type_name;
	}
	public void setResource_type_name(String resource_type_name) {
		this.resource_type_name = resource_type_name;
	}
	public String getResource_dec() {
		return resource_dec;
	}
	public void setResource_dec(String resource_dec) {
		this.resource_dec = resource_dec;
	}
	public String getResource_price() {
		return resource_price;
	}
	public void setResource_price(String resource_price) {
		this.resource_price = resource_price;
	}
	public cart() {
		super();
	}
	public cart(String id, String resource_id, String user_id, int status, int counts, String resource_type_id,
			String resource_type_name, String resource_dec, String resource_price) {
		super();
		this.resource_id = resource_id;
		this.user_id = user_id;
		this.status = status;
		this.counts = counts;
		this.resource_type_id = resource_type_id;
		this.resource_type_name = resource_type_name;
		this.resource_dec = resource_dec;
		this.resource_price = resource_price;
	}
	@Override
	public String toString() {
		return "cart [resource_id=" + resource_id + ", user_id=" + user_id + ", status=" + status + ", counts=" + counts
				+ ", resource_type_id=" + resource_type_id + ", resource_type_name=" + resource_type_name
				+ ", resource_dec=" + resource_dec + ", resource_price=" + resource_price + "]";
	}
	
	
}
