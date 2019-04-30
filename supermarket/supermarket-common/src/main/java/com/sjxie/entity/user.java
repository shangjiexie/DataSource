package com.sjxie.entity;

import java.io.Serializable;

public class user implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user_id;
	private String user_name;
	private String user_sex;
	private String user_age;
	private String user_image;
	private String user_email;
	private String user_password;
	private String user_adress;
	private String user_type;
	private String user_phone;
	public user() {
		super();
	}
	public user(String user_id, String user_name, String user_sex, String user_age, String user_image,
			String user_email, String user_password, String user_adress, String user_type, String user_phone) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_age = user_age;
		this.user_image = user_image;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_adress = user_adress;
		this.user_type = user_type;
		this.user_phone = user_phone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_adress() {
		return user_adress;
	}
	public void setUser_adress(String user_adress) {
		this.user_adress = user_adress;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", user_name=" + user_name + ", user_sex=" + user_sex + ", user_age="
				+ user_age + ", user_image=" + user_image + ", user_email=" + user_email + ", user_password="
				+ user_password + ", user_adress=" + user_adress + ", user_type=" + user_type + ", user_phone="
				+ user_phone + "]";
	}
	
}
