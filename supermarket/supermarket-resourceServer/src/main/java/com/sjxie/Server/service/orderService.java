package com.sjxie.Server.service;

import java.util.List;
import com.sjxie.dto.Result;
import com.sjxie.entity.order;
import com.sjxie.vo.orderVo;

public interface orderService {

	Result<Integer> addOrder(order order);

	Result<List<orderVo>> getOrderListByUser(String user_id);

	Result<Integer> getOrderCountByUserId(String user_id);

	Result<List<orderVo>> getOrderListByUserAndStatus(String user_id, int order_status);

	Result<Integer> getOrderCountByUserIdAndStatus(String user_id, int order_status);
	
	Integer getOrderCountByStatus(Integer status);
	
	Result<Integer> updateOrderStatus(String user_id,String resource_id,int resource_status);

	Result<Integer> updateCartStatus(String user_id,String resource_id,int resource_status);
	
	Result<Integer> deleteOrderById(String resource_id);
	
	Result<Integer> deleteCartById(String resource_id);
	
	Result<List<orderVo>> getOrdersByStatus(Integer status);
	
}
