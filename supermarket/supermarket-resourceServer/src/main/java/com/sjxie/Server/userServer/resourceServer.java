package com.sjxie.Server.userServer;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.sjxie.Server.service.commentService;
import com.sjxie.Server.service.resourceService;
import com.sjxie.Server.service.orderService;
import com.sjxie.dto.Result;
import com.sjxie.entity.cart;
import com.sjxie.entity.comment;
import com.sjxie.entity.order;
import com.sjxie.entity.resource;
import com.sjxie.vo.orderVo;
import com.sjxie.vo.resourceCarVo;

import resourceApi.resourceApi;

@RestController
public class resourceServer implements resourceApi {
	@Autowired
	private resourceService resourceservice;
	@Autowired
	private commentService commentService;
	@Autowired
	private orderService orderService;

	@Override
	public Result<List<resource>> getResourceList(String resource_type, int pageNum, int pageSize) {
		Result<List<resource>> result = new Result<List<resource>>(1, "查询成功");
		PageHelper.startPage(pageNum, pageSize);
		List<resource> resourceList = resourceservice.getResourceList(resource_type);
		if (null == resourceList) {
			result.setCode("0");
			result.setMessage("查询失败");
		}
		result.setData(resourceList);
		return result;
	}

	@Override
	public Result<Integer> countResource() {
		Result<Integer> result = new Result<Integer>(1, "查询成功");
		Integer resCount = resourceservice.countResource();
		if (null == resCount) {
			result.setCode("0");
			result.setMessage("查询失败");
		}
		result.setData(resCount);
		return result;
	}

	@Override
	public Result<Integer> countResourceByType(String resource_type) {
		Result<Integer> result = new Result<Integer>(1, "查询成功");
		Integer resCount = resourceservice.countResourceByType(resource_type);
		if (null == resCount) {
			result.setCode("0");
			result.setMessage("查询失败");
		}
		result.setData(resCount);
		return result;
	}

	@Override
	public Result<Integer> addResource(String resource_id, String resource_name, String resource_dec,
			String resource_type, String resource_price, String resource_img, String resource_specification,
			Integer resource_inventory) {
		Result<Integer> result = new Result<>(1, "添加成功");
		resource res = new resource();
		res.setResource_id(resource_id);
		res.setResource_name(resource_name);
		res.setResource_price(resource_price);
		res.setResource_type(resource_type);
		res.setResource_dec(resource_dec);
		res.setResource_img(resource_img);
		res.setResource_specification(resource_specification);
		res.setResource_inventory(resource_inventory);
		Integer addResource = resourceservice.addResource(res);
		result.setData(addResource);
		return result;
	}

	@Override
	public Result<Integer> deleteResourceById(String resource_id) {
		Result<Integer> result = new Result<>(1, "添加成功");
		Integer deleteResourceById = resourceservice.deleteResourceById(resource_id);
		result.setData(deleteResourceById);
		return result;
	}

	@Override
	public Result<List<resourceCarVo>> getMyResourceByStatus(String user_id, Integer status) {
		Result<List<resourceCarVo>> result = new Result<>(1, "查询成功");
		List<resourceCarVo> myResourceByStatus = resourceservice.getMyResourceByStatus(user_id, status);
		result.setData(myResourceByStatus);
		return result;
	}

	@Override
	public Result<resource> getResourceByResourceId(String resource_id) {
		Result<resource> result = new Result<>(1, "查询成功");
		resource resourceByResourceId = resourceservice.getResourceByResourceId(resource_id);
		result.setData(resourceByResourceId);
		return result;
	}

	@Override
	public Result<List<comment>> getCommentListByResourceId(String resource_id, int pageNum, int pageSize) {
		Result<List<comment>> result = new Result<>(1, "查询成功");
		PageHelper.startPage(pageNum, pageSize);
		List<comment> commentListByResourceId = commentService.getCommentListByResourceId(resource_id);
		result.setData(commentListByResourceId);
		return result;
	}

	@Override
	public Result<Integer> addComment(String resource_id, Integer comment_score, String comment_content,
			Date comment_time, String comment_user_id, String comment_user_name) {
		comment comment = new comment();
		comment.setResource_id(resource_id);
		comment.setComment_score(comment_score);
		comment.setComment_content(comment_content);
		comment.setComment_time(new Date());
		comment.setComment_user_id(comment_user_id);
		comment.setComment_user_name(comment_user_name);
		Result<Integer> addComment = commentService.addComment(comment);
		return addComment;
	}

	@Override
	public Result<String> avgScore(String resource_id) {
		Result<String> avgScore = commentService.avgScore(resource_id);
		return avgScore;
	}

	@Override
	public Result<Integer> getCommentCountByResourceId(String resource_id) {
		Result<Integer> commentCountByResourceId = commentService.getCommentCountByResourceId(resource_id);
		return commentCountByResourceId;
	}

	@Override
	public Result<List<orderVo>> getOrderListByUser(String user_id, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Result<List<orderVo>> orderListByUser = orderService.getOrderListByUser(user_id);
		return orderListByUser;
	}

	@Override
	public Result<Integer> getOrderCountByUserId(String user_id) {
		Result<Integer> orderCountByUserId = orderService.getOrderCountByUserId(user_id);
		return orderCountByUserId;
	}

	@Override
	public Result<Integer> addOrder(String id, String order_resource_id, String order_user_id,
			@RequestParam("order_price") String order_price, Date order_time, @RequestParam("time") String time,
			String order_province, @RequestParam("order_city") String order_city, String order_county,
			@RequestParam("order_adress") String order_adress, int order_status,
			@RequestParam("order_count") int order_count, String order_discounts_id, String order_user_phone) {
		order order = new order(id, order_resource_id, order_user_id, order_price, order_time, time, order_province,
				order_city, order_county, order_adress, order_status, order_count, order_discounts_id,
				order_user_phone);
		Result<Integer> addOrder = orderService.addOrder(order);
		return addOrder;
	}

	@Override
	public Result<List<orderVo>> getOrderListByUserAndStatus(String user_id, int order_status, int pageNum,
			int pageSize) {
		Result<List<orderVo>> result = new Result<List<orderVo>>(1, "success");
		PageHelper.startPage(pageNum, pageSize);
		Result<List<orderVo>> orderListByUserAndStatus = orderService.getOrderListByUserAndStatus(user_id,
				order_status);
		result.setData(orderListByUserAndStatus.getData());
		return result;
	}

	@Override
	public Result<Integer> getOrderCountByUserIdAndStatus(String user_id, int order_status) {
		Result<Integer> orderCountByUserIdAndStatus = orderService.getOrderCountByUserIdAndStatus(user_id,
				order_status);
		return orderCountByUserIdAndStatus;
	}

	@Override
	public Result<Integer> updateOrderStatus(String user_id, String resource_id, int resource_status) {
		Result<Integer> updateOrderStatus = orderService.updateOrderStatus(user_id, resource_id, resource_status);
		return updateOrderStatus;
	}

	@Override
	public Result<Integer> updateCartStatus(String user_id, String resource_id, int resource_status) {
		Result<Integer> updateCartStatus = orderService.updateCartStatus(user_id, resource_id, resource_status);
		return updateCartStatus;
	}

	@Override
	public Result<Integer> deleteOrderById(String resource_id) {
		Result<Integer> deleteOrderById = orderService.deleteOrderById(resource_id);
		return deleteOrderById;
	}

	@Override
	public Result<Integer> deleteCartById(String resource_id) {
		Result<Integer> deleteCartById = orderService.deleteCartById(resource_id);
		return deleteCartById;
	}

	@Override
	public Result<List<orderVo>> getOrdersByStatus(Integer status) {
		Result<List<orderVo>> ordersByStatus = orderService.getOrdersByStatus(status);
		if(ordersByStatus.isSuccess()) {
			return ordersByStatus;
		}
		return new Result<List<orderVo>>(0,"失败");
	}

	@Override
	public Result<Integer> getOrderCountByStatus(Integer status) {
		Result<Integer> result = new Result<Integer>();
		Integer orderCountByStatus = orderService.getOrderCountByStatus(status);
		if(orderCountByStatus != null) {
			result.setData(orderCountByStatus);
		}else {
			return new Result<Integer>(0,"失败");
		}
		return result;
	}

	@Override
	public Result<Integer> addCart(String resourceId, String userId) {
		if(StringUtils.isEmpty(resourceId) ||  StringUtils.isEmpty(userId)) {
			return new Result<Integer>(0,"参数错误");
		}
		Result<Integer> result = new Result<Integer>(1,"成功");
		resource resourceByResource = resourceservice.getResourceByResourceId(resourceId);
		cart cart = new cart();
		cart.setResource_id(resourceId);
		cart.setUser_id(userId);
		cart.setStatus(2);
		cart.setCounts(1);
		cart.setResource_type_id(resourceByResource.getResource_type());
		cart.setResource_type_name(resourceByResource.getResource_type());
		cart.setResource_dec(resourceByResource.getResource_dec());
		cart.setResource_price(resourceByResource.getResource_price());
		Integer addCart = resourceservice.addCart(cart);
		result.setData(addCart);
		return result;
	}

	@Override
	public Result<List<resource>> resourceByResourceLikeName(String searchContext) {
		Result<List<resource>> result = new Result<List<resource>>(1,"成功");
		List<resource> resourceByResourceLikeName = resourceservice.getResourceByResourceLikeName(searchContext);
		if(resourceByResourceLikeName != null) {
			result.setData(resourceByResourceLikeName);
		}else {
			return new Result<List<resource>>(0,"失败"); 
		}
		return result;
	}

	@Override
	public Result<List<resource>> getAllResourceList(int pageNum, int pageSize) {
		Result<List<resource>> result = new Result<List<resource>>();
		PageHelper.startPage(pageNum, pageSize);
		List<resource> allResourceList = resourceservice.getAllResourceList();
		if(allResourceList == null) {
			return new Result<List<resource>>(0,"失败");
		}
		result.setData(allResourceList);
		return result;
	}

}
