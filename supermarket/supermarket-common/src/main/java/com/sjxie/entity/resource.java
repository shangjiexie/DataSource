package com.sjxie.entity;

import java.io.Serializable;

public class resource implements Serializable{
	private static final long serialVersionUID = 1L;
	private String resource_id;
	private String resource_name;
	private String resource_dec;
	private String resource_type;
	private String resource_price;
	private String resource_img;
	private String resource_specification;
	private Integer resource_inventory;
	private Integer resource_sales_volume;
	private Integer resource_evaluate_count;
	private Integer resource_view_count;
	public resource() {
		super();
	}
	public resource(String resource_id, String resource_name, String resource_dec, String resource_type,
			String resource_price, String resource_img, String resource_specification, Integer resource_inventory,
			Integer resource_sales_volume, Integer resource_evaluate_count, Integer resource_view_count) {
		super();
		this.resource_id = resource_id;
		this.resource_name = resource_name;
		this.resource_dec = resource_dec;
		this.resource_type = resource_type;
		this.resource_price = resource_price;
		this.resource_img = resource_img;
		this.resource_specification = resource_specification;
		this.resource_inventory = resource_inventory;
		this.resource_sales_volume = resource_sales_volume;
		this.resource_evaluate_count = resource_evaluate_count;
		this.resource_view_count = resource_view_count;
	}
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
	public String getResource_specification() {
		return resource_specification;
	}
	public void setResource_specification(String resource_specification) {
		this.resource_specification = resource_specification;
	}
	public Integer getResource_inventory() {
		return resource_inventory;
	}
	public void setResource_inventory(Integer resource_inventory) {
		this.resource_inventory = resource_inventory;
	}
	public Integer getResource_sales_volume() {
		return resource_sales_volume;
	}
	public void setResource_sales_volume(Integer resource_sales_volume) {
		this.resource_sales_volume = resource_sales_volume;
	}
	public Integer getResource_evaluate_count() {
		return resource_evaluate_count;
	}
	public void setResource_evaluate_count(Integer resource_evaluate_count) {
		this.resource_evaluate_count = resource_evaluate_count;
	}
	public Integer getResource_view_count() {
		return resource_view_count;
	}
	public void setResource_view_count(Integer resource_view_count) {
		this.resource_view_count = resource_view_count;
	}
	@Override
	public String toString() {
		return "resource [resource_id=" + resource_id + ", resource_name=" + resource_name + ", resource_dec="
				+ resource_dec + ", resource_type=" + resource_type + ", resource_price=" + resource_price
				+ ", resource_img=" + resource_img + ", resource_specification=" + resource_specification
				+ ", resource_inventory=" + resource_inventory + ", resource_sales_volume=" + resource_sales_volume
				+ ", resource_evaluate_count=" + resource_evaluate_count + ", resource_view_count="
				+ resource_view_count + "]";
	}
	
}
