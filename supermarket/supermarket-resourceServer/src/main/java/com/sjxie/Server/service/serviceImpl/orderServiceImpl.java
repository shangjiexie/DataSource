package com.sjxie.Server.service.serviceImpl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjxie.Server.Dao.orderDao;
import com.sjxie.Server.service.orderService;
import com.sjxie.dto.Result;
import com.sjxie.entity.order;
import com.sjxie.vo.orderVo;

@Service
public class orderServiceImpl implements orderService {
	@Autowired
	private orderDao orderdao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Result<Integer> addOrder(order order) {
		Result<Integer> result = new Result<Integer>(1,"成功");
		Integer addOrder = orderdao.addOrder(order);
		logger.info("调用地址:addOrder;返回结果："+addOrder);
		result.setData(addOrder);
		return result;
	}

	@Override
	public Result<List<orderVo>> getOrderListByUser(String user_id) {
		Result<List<orderVo>> result = new Result<List<orderVo>>(1,"成功");
		List<orderVo> orderListByUser = orderdao.getOrderListByUser(user_id);
		logger.info("调用地址:orderListByUser;返回结果："+orderListByUser);
		if (CollectionUtils.isNotEmpty(orderListByUser)) {
			result.setData(orderListByUser);
		}else {
			return new Result<List<orderVo>>(0,"无数据");
		}
		return result;
	}

	@Override
	public Result<Integer> getOrderCountByUserId(String user_id) {
		Result<Integer> result = new Result<Integer>(1,"成功");
		Integer orderCountByResourceId = orderdao.getOrderCountByUserId(user_id);
		logger.info("调用地址:orderCountByResourceId;返回结果："+orderCountByResourceId);
		if(orderCountByResourceId > 0) {
			result.setData(orderCountByResourceId);
		}else {
			return new Result<Integer>(0,"失败 ");
		}
		return result;
	}

	@Override
	public Result<List<orderVo>> getOrderListByUserAndStatus(String user_id, int order_status) {
		Result<List<orderVo>> result = new Result<List<orderVo>>();
		List<orderVo> orderListByUserAndStatus = orderdao.getOrderListByUserAndStatus(user_id, order_status);
		logger.info("调用地址:orderListByUserAndStatus;返回结果："+orderListByUserAndStatus);
		result.setData(orderListByUserAndStatus);
		return result;
	}

	@Override
	public Result<Integer> getOrderCountByUserIdAndStatus(String user_id, int order_status) {
		Result<Integer> result = new Result<Integer>();
		Integer orderCountByUserIdAndStatus = orderdao.getOrderCountByUserIdAndStatus(user_id, order_status);
		logger.info("调用地址:orderCountByUserIdAndStatus;返回结果："+orderCountByUserIdAndStatus);
		result.setData(orderCountByUserIdAndStatus);
		return result;
	}

	@Override
	public Result<Integer> updateOrderStatus(String user_id, String resource_id, int resource_status) {
		Result<Integer> result = new Result<Integer>();
		Integer updateOrderStatus = orderdao.updateOrderStatus(user_id, resource_id, resource_status);
		logger.info("调用地址:updateOrderStatus;返回结果："+updateOrderStatus);
		result.setData(updateOrderStatus);
		return result;
	}

	@Override
	public Result<Integer> updateCartStatus(String user_id, String resource_id, int resource_status) {
		Result<Integer> result = new Result<Integer>();
		Integer updateCartStatus = orderdao.updateCartStatus(user_id, resource_id, resource_status);
		logger.info("调用地址:updateCartStatus;返回结果："+updateCartStatus);
		result.setData(updateCartStatus);
		return result;
	}

	@Override
	public Result<Integer> deleteOrderById(String resource_id) {
		Result<Integer> result = new Result<Integer>();
		Integer deleteOrderById = orderdao.deleteOrderById(resource_id);
		logger.info("调用地址:deleteOrderById;返回结果："+deleteOrderById);
		result.setData(deleteOrderById);
		return result;
	}

	@Override
	public Result<Integer> deleteCartById(String resource_id) {
		Result<Integer> result = new Result<Integer>();
		Integer deleteCartById = orderdao.deleteCartById(resource_id);
		logger.info("调用地址:deleteCartById;返回结果："+deleteCartById);
		result.setData(deleteCartById);
		return result;
	}

	@Override
	public Result<List<orderVo>> getOrdersByStatus(Integer status) {
		Result<List<orderVo>> result = new Result<List<orderVo>>(1,"成功");
		List<orderVo> ordersByStatus = orderdao.getOrdersByStatus(status);
		if(ordersByStatus != null) {
			result.setData(ordersByStatus);
		}else {
			return new Result<List<orderVo>>(0,"失败");
		}
		return result;
	}

	@Override
	public Integer getOrderCountByStatus(Integer status) {
		Integer orderCountByStatus = orderdao.getOrderCountByStatus(status);
		return orderCountByStatus;
	}
	
}
