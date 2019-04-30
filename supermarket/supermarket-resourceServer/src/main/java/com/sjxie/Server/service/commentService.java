package com.sjxie.Server.service;

import java.util.List;

import com.sjxie.dto.Result;
import com.sjxie.entity.comment;

public interface commentService {
	
	List<comment> getCommentListByResourceId(String resource_id);
	
	Result<Integer> addComment(comment comment);
	
	Result<String> avgScore(String resource_id);
	
	Result<Integer> getCommentCountByResourceId(String resource_id);
}
