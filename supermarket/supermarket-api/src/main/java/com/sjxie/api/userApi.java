package com.sjxie.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjxie.dto.Result;
import com.sjxie.entity.user;

@RequestMapping("userServer")
public interface userApi {
	/**
	 * 根据用户id获取用户详情
	 * @param user_id
	 * @return
	 */
	 @RequestMapping(value = "/getUser")
	 public Result<user> getUser(@RequestParam("user_id")String user_id);
	 
	 /**
	  * 登录
	  * @param user_name
	  * @param user_password
	  * @return
	  */
	 @RequestMapping(value = "/login")
	 public Result<Boolean> login(@RequestParam("user_name")String user_name,@RequestParam("user_password")String user_password);
	 
	 /**
	  * 注册
	  * @param user_id
	  * @param user_name
	  * @param user_email
	  * @param user_phone
	  * @param user_password
	  * @return
	  */
	 @RequestMapping(value = "/register")
	 public Result<Boolean> register(@RequestParam("user_id")String user_id,@RequestParam("user_name")String user_name,@RequestParam("user_email")String user_email,@RequestParam("user_phone")String user_phone,@RequestParam("user_password")String user_password);
	 
	 /**
	  * 获取用户列表
	  * @param pageNum
	  * @param pageSize
	  * @return
	  */
	 @RequestMapping(value = "/getUserList")
	 public Result<List<user>> getUserList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);
	 
	/**
	 * 修改个人信息
	 * @param user_id
	 * @param user_name
	 * @param user_sex
	 * @param user_age
	 * @param user_image
	 * @param user_email
	 * @param user_password
	 * @param user_adress
	 * @param user_type
	 * @param user_phone
	 * @return
	 */
	@RequestMapping(value = "/updateMyInfo")
	Result<Integer> updateMyInfo(@RequestParam("user_id") String user_id, @RequestParam("user_name") String user_name,
			@RequestParam("user_sex") String user_sex, @RequestParam("user_age") String user_age,
			@RequestParam("user_image") String user_image, @RequestParam("user_email") String user_email,
			@RequestParam("user_password") String user_password, @RequestParam("user_adress") String user_adress,
			@RequestParam("user_type") String user_type, @RequestParam("user_phone") String user_phone);
	
	/**
	 * 根据登录用户名查询用户
	 * @param user_name
	 * @return
	 */
	@RequestMapping(value = "/getUserByUserName")
	Result<user> getUserByUserName(@RequestParam("user_name") String user_name);
	
	/**
	 * 修改用户的类型
	 * @param user_type
	 * @return
	 */
	@RequestMapping(value = "/updateUserType")
	Result<Boolean> updateUserType(@RequestParam("user_id")String user_id,@RequestParam("user_type")String user_type);
}
