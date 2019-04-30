package com.sjxie.entity;

import java.io.Serializable;
import java.util.Date;

public class comment implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String resource_id;
	private Integer comment_score;
	private String comment_content;
	private Date comment_time;
	private String comment_user_id;
	private String comment_user_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	public Integer getComment_score() {
		return comment_score;
	}
	public void setComment_score(Integer comment_score) {
		this.comment_score = comment_score;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public Date getComment_time() {
		return comment_time;
	}
	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}
	public String getComment_user_id() {
		return comment_user_id;
	}
	public void setComment_user_id(String comment_user_id) {
		this.comment_user_id = comment_user_id;
	}
	public String getComment_user_name() {
		return comment_user_name;
	}
	public void setComment_user_name(String comment_user_name) {
		this.comment_user_name = comment_user_name;
	}
	public comment() {
		super();
	}
	public comment(int id, String resource_id, Integer comment_score, String comment_content, Date comment_time,
			String comment_user_id, String comment_user_name) {
		super();
		this.id = id;
		this.resource_id = resource_id;
		this.comment_score = comment_score;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
		this.comment_user_id = comment_user_id;
		this.comment_user_name = comment_user_name;
	}
	@Override
	public String toString() {
		return "comment [id=" + id + ", resource_id=" + resource_id + ", comment_score=" + comment_score
				+ ", comment_content=" + comment_content + ", comment_time=" + comment_time + ", comment_user_id="
				+ comment_user_id + ", comment_user_name=" + comment_user_name + "]";
	}
	
	
	
}
