package com.sjxie.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sjxie.dto.BaseController;
import com.sjxie.dto.Result;
import com.sjxie.entity.resource;
import com.sjxie.entity.user;
import com.sjxie.service.resourceService;
import com.sjxie.service.userService;
import com.sjxie.vo.orderVo;
/**
 * 订单控制层
 * @author xsj
 *
 */
@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/orders")
public class orderController extends BaseController{
	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private resourceService resourceService;
	
	@Autowired
	private userService userService;
	
	/**
	 * 下单
	 * @return
	 */
	@RequestMapping("/addOrder")
	public Result<Integer> addOrder(HttpServletRequest request,String resourceId){
		user lOginUser = this.getLOginUser(request);
		if(lOginUser == null) {
			return new Result<Integer>(0,"请先登录");
		}
		String replaceAll = UUID.randomUUID().toString().replaceAll(" ", "");
		Result<resource> resourceByResourceId = resourceService.getResourceByResourceId(resourceId);
		Result<user> user = userService.getUser(lOginUser.getUser_id());
		if(resourceByResourceId.isSuccess() && resourceByResourceId.getData() != null && user.isSuccess() && user.getData() != null) {
			resource resourceInfo = resourceByResourceId.getData();
			com.sjxie.entity.user userInfo = user.getData();
			Date date = new Date();
			DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = dFormat.format(date); 
			Result<Integer> addOrder = resourceService.addOrder(replaceAll, resourceInfo.getResource_id(), lOginUser.getUser_id(), resourceInfo.getResource_price(), date, format, "", "", "", user.getData().getUser_adress(), 1, 1, "", userInfo.getUser_phone());
			return addOrder;
		}
		
		return new Result<Integer>(0,"失败");
	}
	
	/**
	 * 根据用户ID获取所有的订单集合
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getOrderListByUser")
	public Result<List<orderVo>> getOrderListByUser(int pageNum,int pageSize){
		String user_id = "ccdbab24f1484886a918207776ca59471554167478947";
		Result<List<orderVo>> orderListByUser = resourceService.getOrderListByUser(user_id,pageNum,pageSize);
		Result<Integer> orderCountByUserId = resourceService.getOrderCountByUserId(user_id);
		orderListByUser.setPage(pageNum, pageSize, 8, orderCountByUserId.getData());
		return orderListByUser;
	}
	
	/**
	 * 根据用户ID获取订单的总数
	 * @return
	 */
	@RequestMapping("/getOrderCountByUserId")
	public Result<Integer> getOrderCountByUserId(){
		String user_id = "ccdbab24f1484886a918207776ca59471554167478947";
		Result<Integer> orderCountByUserId = resourceService.getOrderCountByUserId(user_id);
		return orderCountByUserId;
	}

	/**
	 * 根据用户ID和订单状态获取订单集合
	 * @param order_status
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getOrderListByUserAndStatus")
	public Result<List<orderVo>> getOrderListByUserAndStatus(HttpServletRequest request,int order_status,int pageNum,int pageSize) {
		user loginUser = this.getLOginUser(request);
		if(loginUser == null || loginUser.getUser_id() == null) {
			return new Result<>(0, "未登录");
		}
		Result<List<orderVo>> orderListByUserAndStatus = resourceService.getOrderListByUserAndStatus(loginUser.getUser_id(), order_status,pageNum,pageSize);
		Result<Integer> orderCountByUserIdAndStatus = resourceService.getOrderCountByUserIdAndStatus(loginUser.getUser_id(), order_status);
		orderListByUserAndStatus.setPage(pageNum, pageSize, pageNum, orderCountByUserIdAndStatus.getData());
		return orderListByUserAndStatus;
	}
	
	/**
	 * 获取用户指定状态的订单
	 * @param order_status
	 * @return
	 */
	@RequestMapping("/getOrderCountByUserIdAndStatus")
	public Result<Integer> getOrderCountByUserIdAndStatus(int order_status) {
		String user_id = "ccdbab24f1484886a918207776ca59471554167478947";
		Result<Integer> orderCountByUserIdAndStatus = resourceService.getOrderCountByUserIdAndStatus(user_id, order_status);
		return orderCountByUserIdAndStatus;
	}
	
	/**
	 * 删除订单
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("/deleteOrderById")
	public Result<Integer> deleteOrderById(String resource_id){
		Result<Integer> deleteOrderById = resourceService.deleteOrderById(resource_id);
		return deleteOrderById;
	}
	
	/**
	 * 删除购物车
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("/deleteCartById")
	public Result<Integer> deleteCartById(String resource_id){
		Result<Integer> deleteOrderById = resourceService.deleteCartById(resource_id);
		return deleteOrderById;
	}
	
	/**
	 * 结算购物车，批量购买商品
	 * @param resource_id
	 * @param user_name
	 * @param user_phone
	 * @param province
	 * @param city
	 * @param county
	 * @param adress
	 * @return
	 */
	@RequestMapping("checkOutCart")
	public Result<Integer> orderResource(HttpServletRequest request,String resource_id,String user_name,String user_phone,String province,String city,String county ,String adress){
		if(StringUtils.isEmpty(resource_id)) {
			return new Result<Integer>(0,"参数错误");
		}
		String[] ResourceIds = resource_id.split(",");
		for (int i = 0; i < ResourceIds.length; i++) {
			if(StringUtils.isNotEmpty(ResourceIds[i])) {
				Result<resource> resourceByResourceId = resourceService.getResourceByResourceId(ResourceIds[i]);
				if(resourceByResourceId.isSuccess() && resourceByResourceId.getData() != null) {
					resource resourceInfo = resourceByResourceId.getData();
					String uuId = UUID.randomUUID().toString().replaceAll(" ", "");
					resourceService.addOrder(uuId, resourceInfo.getResource_id(), this.getLOginUser(request).getUser_id(), resourceInfo.getResource_price(), new Date(), "2019年4月19号", province, city, county, adress, 1, 1, "0", user_phone);
				}
			}
		}
		
		return new Result<Integer>(1,"未查询到数据");
	}

	/**
	 * 根据订单状态获取所有订单
	 * @param status
	 * @return
	 */
	@RequestMapping("getOrdersByStatus")
	Result<List<orderVo>> getOrdersByStatus(Integer status){
		Result<Integer> orderCountByStatus = resourceService.getOrderCountByStatus(status);
		Result<List<orderVo>> ordersByStatus = resourceService.getOrdersByStatus(status);
		if(ordersByStatus.isSuccess() && orderCountByStatus.isSuccess() && ordersByStatus.getData() != null && ordersByStatus.getData() != null) {
			ordersByStatus.setPage(1, 1, 1, orderCountByStatus.getData());
			return ordersByStatus;
		}
		return new Result<List<orderVo>>(1,"失败");
	}
}
