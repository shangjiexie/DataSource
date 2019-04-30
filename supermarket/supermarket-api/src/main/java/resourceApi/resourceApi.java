package resourceApi;

import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sjxie.dto.Result;
import com.sjxie.entity.comment;
import com.sjxie.entity.resource;
import com.sjxie.vo.orderVo;
import com.sjxie.vo.resourceCarVo;

@RequestMapping("resourceServer")
public interface resourceApi {
	/**
	 * 根据商品类型获取商品列表
	 * 
	 * @param resource_type
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/getResourceList")
	public Result<List<resource>> getResourceList(@RequestParam("resource_type") String resource_type,
			@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

	/**
	 * 获取所有商品
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/getAllResourceList")
	public Result<List<resource>> getAllResourceList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);
	/**
	 * 获取商品总数
	 * 
	 * @return
	 */
	@RequestMapping("countResource")
	public Result<Integer> countResource();

	/**
	 * 根据商品类型获取商品总数
	 * 
	 * @param resource_type
	 * @return
	 */
	@RequestMapping("countResourceByType")
	public Result<Integer> countResourceByType(@RequestParam("resource_type") String resource_type);

	/**
	 * 添加商品
	 * 
	 * @param resource_id
	 * @param resource_name
	 * @param resource_dec
	 * @param resource_type
	 * @param resource_price
	 * @param resource_img
	 * @param resource_specification
	 * @return
	 */
	@RequestMapping("addResource")
	public Result<Integer> addResource(@RequestParam("resource_id") String resource_id,
			@RequestParam("resource_name") String resource_name, @RequestParam("resource_dec") String resource_dec,
			@RequestParam("resource_type") String resource_type, @RequestParam("resource_price") String resource_price,
			@RequestParam("resource_img") String resource_img,
			@RequestParam("resource_specification") String resource_specification,
			@RequestParam("resource_inventory") Integer resource_inventory);

	/**
	 * 根据商品id删除商品
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("deleteResourceById")
	public Result<Integer> deleteResourceById(@RequestParam("resource_id") String resource_id);

	/**
	 * 获取我的商品（购物车，历史订单，待收货等状态）
	 * 
	 * @param user_id
	 * @param status
	 * @return
	 */
	@RequestMapping("getMyResourceByStatus")
	public Result<List<resourceCarVo>> getMyResourceByStatus(@RequestParam("user_id") String user_id,
			@RequestParam("status") Integer status);

	/**
	 * 根据商品id获取商品详情
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("getResourceByResourceId")
	public Result<resource> getResourceByResourceId(@RequestParam("resource_id") String resource_id);

	/**
	 * 获取评论
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("getCommentListByResourceId")
	public Result<List<comment>> getCommentListByResourceId(@RequestParam("resource_id") String resource_id,
			@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

	/**
	 * 添加评论
	 * 
	 * @param resource_id
	 * @param comment_score
	 * @param comment_content
	 * @param comment_time
	 * @param comment_user_id
	 * @param comment_user_name
	 * @return
	 */
	@RequestMapping("addComment")
	Result<Integer> addComment(@RequestParam("resource_id") String resource_id,
			@RequestParam("comment_score") Integer comment_score,
			@RequestParam("comment_content") String comment_content, @RequestParam("comment_time") Date comment_time,
			@RequestParam("comment_user_id") String comment_user_id,
			@RequestParam("comment_user_name") String comment_user_name);

	/**
	 * 计算平均分数
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("avgScore")
	Result<String> avgScore(@RequestParam("resource_id") String resource_id);

	/**
	 * 获取资源下的评论总数
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("getCommentCountByResourceId")
	Result<Integer> getCommentCountByResourceId(@RequestParam("resource_id") String resource_id);

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping("addOrder")
	Result<Integer> addOrder(@RequestParam("id") String id, @RequestParam("order_resource_id") String order_resource_id,
			@RequestParam("order_user_id") String order_user_id, @RequestParam("order_price") String order_price,
			@RequestParam("order_time") Date order_time, @RequestParam("time") String time,
			@RequestParam("order_province") String order_province, @RequestParam("order_city") String order_city,
			@RequestParam("order_county") String order_county, @RequestParam("order_adress") String order_adress,
			@RequestParam("order_status") int order_status, @RequestParam("order_count") int order_count,
			@RequestParam("order_discounts_id") String order_discounts_id,
			@RequestParam("order_user_phone") String order_user_phone);

	/**
	 * 获取用的的订单列表
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping("getOrderListByUser")
	Result<List<orderVo>> getOrderListByUser(@RequestParam("user_id") String user_id,
			@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

	/**
	 * 获取用户的订单数量
	 * 
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("getOrderCountByUserId")
	Result<Integer> getOrderCountByUserId(@RequestParam("user_id") String user_id);

	/**
	 * 获取用户指定的状态的订单列表
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping("getOrderListByUserAndStatus")
	Result<List<orderVo>> getOrderListByUserAndStatus(@RequestParam("user_id") String user_id,
			@RequestParam("order_status") int order_status, @RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 获取用户指定的状态的订单数量
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping("getOrderCountByUserIdAndStatus")
	Result<Integer> getOrderCountByUserIdAndStatus(@RequestParam("user_id") String user_id,
			@RequestParam("order_status") int order_status);
	
	/**
	 * 获取用户指定的状态的订单数量
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping("getOrderCountByStatus")
	Result<Integer> getOrderCountByStatus(@RequestParam("status") Integer status);

	/**
	 * 修改我的订单状态
	 * 
	 * @param user_id
	 * @param resource_id
	 * @param resource_staus
	 * @return
	 */
	@RequestMapping("updateOrderStatus")
	Result<Integer> updateOrderStatus(@RequestParam("user_id") String user_id,
			@RequestParam("resource_id") String resource_id, @RequestParam("resource_status") int resource_status);

	/**
	 * 修改我的购物车状态
	 * 
	 * @param user_id
	 * @param resource_id
	 * @param resource_staus
	 * @return
	 */
	@RequestMapping("updateCartStatus")
	Result<Integer> updateCartStatus(@RequestParam("user_id") String user_id,
			@RequestParam("resource_id") String resource_id, @RequestParam("resource_status") int resource_status);

	/**
	 * 添加购物车
	 * @param resourceId
	 * @param userId
	 * @return
	 */
	@RequestMapping("/addCart")
	Result<Integer> addCart(@RequestParam("resourceId") String resourceId,@RequestParam("userId") String userId);
	
	/**
	 * 删除我的订单
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("deleteOrderById")
	Result<Integer> deleteOrderById(@RequestParam("resource_id") String resource_id);

	/**
	 * 删除购物车
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("deleteCartById")
	Result<Integer> deleteCartById(@RequestParam("resource_id") String resource_id);
	
	/**
	 * 获取不同状态的订单
	 * @param status
	 * @return
	 */
	@RequestMapping("getOrdersByStatus")
	Result<List<orderVo>> getOrdersByStatus(@RequestParam("status")Integer status);
	
	/**
	 * 模糊查询商品
	 * @param resourceName
	 * @return
	 */
	@RequestMapping("resourceByResourceLikeName")
	Result<List<resource>> resourceByResourceLikeName(@RequestParam("searchContext")String searchContext);

}
