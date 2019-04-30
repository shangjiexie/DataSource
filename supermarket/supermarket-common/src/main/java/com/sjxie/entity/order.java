package com.sjxie.entity;

import java.io.Serializable;
import java.util.Date;

public class order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String order_resource_id;
	private String order_user_id;
	private String order_price;
	private Date order_time;
	private String time;
	private String order_province;
	private String order_city;
	private String order_county;
	private String order_adress;
	private int order_status;
	private int order_count;
	private String order_discounts_id;
	private String order_user_phone;
	public order() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_resource_id() {
		return order_resource_id;
	}
	public void setOrder_resource_id(String order_resource_id) {
		this.order_resource_id = order_resource_id;
	}
	public String getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(String order_user_id) {
		this.order_user_id = order_user_id;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOrder_province() {
		return order_province;
	}
	public void setOrder_province(String order_province) {
		this.order_province = order_province;
	}
	public String getOrder_city() {
		return order_city;
	}
	public void setOrder_city(String order_city) {
		this.order_city = order_city;
	}
	public String getOrder_county() {
		return order_county;
	}
	public void setOrder_county(String order_county) {
		this.order_county = order_county;
	}
	public String getOrder_adress() {
		return order_adress;
	}
	public void setOrder_adress(String order_adress) {
		this.order_adress = order_adress;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public String getOrder_discounts_id() {
		return order_discounts_id;
	}
	public void setOrder_discounts_id(String order_discounts_id) {
		this.order_discounts_id = order_discounts_id;
	}
	public String getOrder_user_phone() {
		return order_user_phone;
	}
	public void setOrder_user_phone(String order_user_phone) {
		this.order_user_phone = order_user_phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public order(String id, String order_resource_id, String order_user_id, String order_price, Date order_time,
			String time, String order_province, String order_city, String order_county, String order_adress,
			int order_status, int order_count, String order_discounts_id, String order_user_phone) {
		super();
		this.id = id;
		this.order_resource_id = order_resource_id;
		this.order_user_id = order_user_id;
		this.order_price = order_price;
		this.order_time = order_time;
		this.time = time;
		this.order_province = order_province;
		this.order_city = order_city;
		this.order_county = order_county;
		this.order_adress = order_adress;
		this.order_status = order_status;
		this.order_count = order_count;
		this.order_discounts_id = order_discounts_id;
		this.order_user_phone = order_user_phone;
	}
	@Override
	public String toString() {
		return "order [id=" + id + ", order_resource_id=" + order_resource_id + ", order_user_id=" + order_user_id
				+ ", order_price=" + order_price + ", order_time=" + order_time + ", time=" + time + ", order_province="
				+ order_province + ", order_city=" + order_city + ", order_county=" + order_county + ", order_adress="
				+ order_adress + ", order_status=" + order_status + ", order_count=" + order_count
				+ ", order_discounts_id=" + order_discounts_id + ", order_user_phone=" + order_user_phone + "]";
	}
	
}
