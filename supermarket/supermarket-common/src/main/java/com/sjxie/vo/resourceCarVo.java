package com.sjxie.vo;

import java.io.Serializable;

public class resourceCarVo implements Serializable{
	private static final long serialVersionUID = 1L;
	String resource_id;
	String resource_name;
	String resource_dec;
	String resource_type;
	String resource_price;
	String resource_img;
	String counts;
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getResource_dec() {
		return resource_dec;
	}
	public void setResource_dec(String resource_dec) {
		this.resource_dec = resource_dec;
	}
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	public String getResource_price() {
		return resource_price;
	}
	public void setResource_price(String resource_price) {
		this.resource_price = resource_price;
	}
	public String getResource_img() {
		return resource_img;
	}
	public void setResource_img(String resource_img) {
		this.resource_img = resource_img;
	}
	public String getCounts() {
		return counts;
	}
	public void setCounts(String counts) {
		this.counts = counts;
	}
	public resourceCarVo() {
		super();
	}
	public resourceCarVo(String resource_id, String resource_name, String resource_dec, String resource_type,
			String resource_price, String resource_img, String counts) {
		super();
		this.resource_id = resource_id;
		this.resource_name = resource_name;
		this.resource_dec = resource_dec;
		this.resource_type = resource_type;
		this.resource_price = resource_price;
		this.resource_img = resource_img;
		this.counts = counts;
	}
	@Override
	public String toString() {
		return "resourceCarVo [resource_id=" + resource_id + ", resource_name=" + resource_name + ", resource_dec="
				+ resource_dec + ", resource_type=" + resource_type + ", resource_price=" + resource_price
				+ ", resource_img=" + resource_img + ", counts=" + counts + "]";
	}
	
	
	
}
