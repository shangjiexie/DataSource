package com.sjxie.Server.service.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjxie.Server.Dao.commentDao;
import com.sjxie.Server.service.commentService;
import com.sjxie.dto.Result;
import com.sjxie.entity.comment;

@Service
public class commentServiceImpl implements commentService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	commentDao commentdao;
	
	@Override
	public List<comment> getCommentListByResourceId(String resource_id) {
		List<comment> commentListByResourceId = commentdao.getCommentListByResourceId(resource_id);
		logger.info("调用地址:getCommentListByResourceId;返回结果："+commentListByResourceId);
		return commentListByResourceId;
	}

	@Override
	public Result<Integer> addComment(comment comment) {
		Result<Integer> result = new Result<>(1, "成功");
		Integer addComment = commentdao.addComment(comment);
		logger.info("调用地址:addComment;返回结果："+addComment);
		result.setData(addComment);
		return result;
	}

	@Override
	public Result<String> avgScore(String resource_id) {
		Result<String> result = new Result<>();
		String avgScore = commentdao.avgScore(resource_id);
		logger.info("调用地址:avgScore;返回结果："+avgScore);
		result.setData(avgScore);
		return result;
	}

	@Override
	public Result<Integer> getCommentCountByResourceId(String resource_id) {
		Result<Integer> result = new Result<Integer>();
		Integer commentCountByResourceId = commentdao.getCommentCountByResourceId(resource_id);
		logger.info("调用地址:commentCountByResourceId;返回结果："+commentCountByResourceId);
		result.setData(commentCountByResourceId);
		return result;
	}

}
