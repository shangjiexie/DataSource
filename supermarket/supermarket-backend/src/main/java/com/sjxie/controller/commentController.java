package com.sjxie.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sjxie.dto.BaseController;
import com.sjxie.dto.Result;
import com.sjxie.entity.comment;
import com.sjxie.entity.user;
import com.sjxie.service.resourceService;
import com.sjxie.util.commentUtil;

/**
 * 评价控制层
 * 
 * @author XieShangjie
 *
 */
@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/commentDate")
public class commentController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private resourceService resourceservice;

	/**
	 * 分页获取商品下的评论
	 * 
	 * @param resource_id
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getCommentListByResourceId")
	public Result<JSONArray> getCommentListByResourceId(String resource_id, int pageNum, int pageSize) {
		Result<JSONArray> result = new Result<JSONArray>();
		Result<List<comment>> commentListByResourceId = resourceservice.getCommentListByResourceId(resource_id, pageNum,
				pageSize);
		JSONArray commentResult = new JSONArray();
		if (commentListByResourceId != null && commentListByResourceId.isSuccess()
				&& commentListByResourceId.getData() != null) {
			List<comment> commentData = commentListByResourceId.getData();
			for (int i = 0; i < commentData.size(); i++) {
				JSONObject parseObject = JSONObject.parseObject(JSON.toJSONString(commentData.get(i)));
				// 把时间错转成时间格式
				Date comment_time = commentData.get(i).getComment_time();
				String formateDate = commentUtil.formateDate(comment_time);
				parseObject.put("comment_time", formateDate);
				commentResult.add(parseObject);
			}
			result.setData(commentResult);
		}

		return result;
	}

	/**
	 * 添加评论
	 * 
	 * @return
	 */
	@RequestMapping("/addComment")
	public Result<Integer> addComment(HttpServletRequest request,String resourceId,int commentScore,String commentContent) {
		user loginUser = this.getLOginUser(request);
		if(loginUser == null) {
			return new Result<Integer>(0,"未登录");
		}
		Date newDate = new Date();
		Result<Integer> addComment = resourceservice.addComment(resourceId, commentScore, commentContent, newDate, loginUser.getUser_id(), loginUser.getUser_name());
		return addComment;
	}

	/**
	 * 计算平均分
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("/avgScore")
	public Result<String> avgScore(String resource_id) {
		Result<String> result = new Result<>(1, "成功");
		Result<String> avgScore = resourceservice.avgScore(resource_id);
		if (avgScore.isSuccess() && avgScore.getData() != null) {
			String indexOf = avgScore.getData().substring(0, 3);
			result.setData(indexOf);
			return result;
		}
		Result<String> result2 = new Result<>(0, "无数据");
		result2.setData("0");
		return result2;
	}

	/**
	 * 获取商品的评论数量
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("/getCommentCountByResourceId")
	public Result<Integer> getCommentCountByResourceId(String resource_id) {
		Result<Integer> result = new Result<>(1, "成功");
		Result<Integer> commentCountByResourceId = resourceservice.getCommentCountByResourceId(resource_id);
		if (commentCountByResourceId.isSuccess() && commentCountByResourceId.getData() != null) {
			result.setData(commentCountByResourceId.getData());
			return result;
		}
		return new Result<Integer>(0, "失败");
	}

	/**
	 * 修改订单状态
	 * @param resource_id
	 * @param resource_status
	 * @param request
	 * @return
	 */
	@RequestMapping("updateOrderStatus")
	public Result<Integer> updateOrderStatus(String resourceId, int resourceStatus,HttpServletRequest request) {
		user loginUser = this.getLOginUser(request);
		Result<Integer> updateOrderStatus = resourceservice.updateOrderStatus(loginUser.getUser_id(), resourceId, resourceStatus);
		return updateOrderStatus;
	}

	/**
	 * 更新购物车状态
	 * @param resource_id
	 * @param resource_status
	 * @param request
	 * @return
	 */
	@RequestMapping("updateCartStatus")
	public Result<Integer> updateCartStatus(String resource_id, int resource_status,HttpServletRequest request) {
		user loginUser = this.getLOginUser(request);
		Result<Integer> updateCartStatus = resourceservice.updateCartStatus(loginUser.getUser_id(), resource_id, resource_status);
		return updateCartStatus;
	}
}
