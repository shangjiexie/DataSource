package com.sjxie.Server.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sjxie.entity.comment;

@Mapper
public interface commentDao {
	List<comment> getCommentListByResourceId(String resource_id);
	
	Integer addComment(comment comment);
	
	String avgScore(String resource_id);
	
	Integer getCommentCountByResourceId(String resource_id);
}
