package com.sjxie.Server.Dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sjxie.entity.order;
import com.sjxie.vo.orderVo;

@Mapper
public interface orderDao {

	Integer addOrder(order order);

	List<orderVo> getOrderListByUser(String order_user_id);

	Integer getOrderCountByUserId(String order_user_id);

	List<orderVo> getOrderListByUserAndStatus(@Param("user_id") String user_id,
			@Param("order_status") int order_status);

	Integer getOrderCountByUserIdAndStatus(@Param("user_id") String user_id,
			@Param("order_status") int order_status);
	
	Integer getOrderCountByStatus(@Param("status") Integer status);
	
	Integer updateOrderStatus(@Param("user_id") String user_id,@Param("resource_id")String resource_id,@Param("resource_status")int resource_status);

	Integer updateCartStatus(@Param("user_id") String user_id,@Param("resource_id")String resource_id,@Param("resource_status")int resource_status);
	
	Integer deleteOrderById(@Param("resource_id")String resource_id);
	
	Integer deleteCartById(@Param("resource_id")String resource_id);
	
	List<orderVo> getOrdersByStatus(@Param("status")Integer status);
	
}
