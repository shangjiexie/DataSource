package com.sjxie.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sjxie.dto.BaseController;
import com.sjxie.dto.Result;
import com.sjxie.entity.user;
import com.sjxie.service.userService;

@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/user")
public class userController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	@Autowired
	private userService userservice;

	@RequestMapping(value = "/isAuthor", method = RequestMethod.POST)
	public Result<String> isAuthor(HttpServletRequest request) {
		Result<String> result = new Result<String>(1, "成功查询");
		user loginUser = this.getLOginUser(request);
		if(loginUser != null) {
			result.setData(loginUser.getUser_type());
		}
		return result;
	}
	
	
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
	public Result<user> getUserInfo(HttpServletRequest request, String user_id) {
		Result<user> result = new Result<user>(1, "成功查询");
		try {
			logger.info("调用地址:{},参数{}", "/test/test", user_id);
			result.setData(userservice.getUser(user_id).getData());
		} catch (Exception e) {
			result.setCode("0");
			result.setMessage("调用失败");
			logger.info("getUser调用异常");
		}
		return result;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @param user_name
	 * @param user_password
	 * @author 谢尚杰
	 * @return
	 */
	@RequestMapping(value = "/login")
	public Result<Boolean> login(HttpServletRequest request, HttpServletResponse response, String user_name,
			String user_password) {
		Result<Boolean> result = new Result<Boolean>(1, "登录成功");
		if (userservice.login(user_name, user_password).isSuccess()) {
			HttpSession session = request.getSession();
			Result<user> userByUserName = userservice.getUserByUserName(user_name);
			session.setAttribute("supermarket_sessionID", userByUserName.getData());
			return result;
		} else {
			result.setCode("0");
			result.setMessage("登录失败");
		}
		return result;
	}

	/**
	 * 判断是否登录
	 * 
	 * @param request
	 * @param response
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public Result<String> checkLogin(HttpServletRequest request, HttpServletResponse response, String name) {
		Result<String> result = new Result<String>(1, "已登录");
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		if (sessionID == null) {
			result.setCode("0");
			result.setMessage("未登录");
		}
		result.setData(sessionID);
		return result;
	}

	/**
	 * 注册
	 * 
	 * @param user_name
	 * @param user_email
	 * @param user_phone
	 * @param user_password
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public Result<Boolean> registerUser(String user_name, String user_email, String user_phone, String user_password) {
		if(StringUtils.isNotEmpty(user_name)) {
			Result<user> userByUserName = userservice.getUserByUserName(user_name);
			if(userByUserName != null) {
				return new Result<Boolean>(0, "该用户名已经被使用");
			}
		}
		Result<Boolean> result = new Result<Boolean>(1, "注册成功");
		UUID uuid = UUID.randomUUID();
		String user_id = uuid.toString();
		Result<Boolean> registerstate = userservice.register(user_id, user_name, user_email, user_phone, user_password);
		if (!registerstate.isSuccess()) {
			result.setCode("0");
			result.setMessage("注册失败");
		}
		return result;
	}
	/**
	 * 注册账户
	 * @param user_name
	 * @param user_email
	 * @param user_phone
	 * @param user_password
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result<Boolean> register(String user_name, String user_email, String user_phone, String user_password) {
		if(StringUtils.isNotEmpty(user_name)) {
			Result<user> userByUserName = userservice.getUserByUserName(user_name);
			if(userByUserName != null) {
				return new Result<Boolean>(0, "该用户名已经被使用");
			}
		}
		Result<Boolean> result = new Result<Boolean>(1, "注册成功");
		UUID uuid = UUID.randomUUID();
		long time = new Date().getTime();
		String user_id = uuid.toString().replaceAll("-", "") + time;
		Result<Boolean> register = userservice.register(user_id, user_name, user_email, user_phone, user_password);
		if (register.isSuccess()) {
			result.setData(register.getData());
		}
		return result;
	}

	/**
	 * 获取用户列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/getUerList", method = RequestMethod.POST)
	public Result<List<user>> getUserList(int pageNum, int pageSize) {
		Result<List<user>> userList = userservice.getUserList(pageNum, pageSize);
		return userList;
	}

	/**
	 * 修改个人信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateMyInfo", method = RequestMethod.POST)
	public Result<Integer> updateMyInfo(user user) {
		Result<Integer> updateMyInfo = userservice.updateMyInfo(user.getUser_id(), user.getUser_name(),
				user.getUser_sex(), user.getUser_age(), user.getUser_image(), user.getUser_email(),
				user.getUser_password(), user.getUser_adress(), user.getUser_type(), user.getUser_phone());
		return updateMyInfo;
	}

	@RequestMapping(value = "/updateUserType" , method = RequestMethod.POST)
	public Result<Boolean> updateUserType(HttpServletRequest request,String userId,String userType){
		Result<Boolean> result = new Result<Boolean>(0,"失败");
		if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(userType)) {
			return new Result<Boolean>(0,"参数不正确");
		}
		user loginUser = this.getLOginUser(request);
		if(loginUser == null) {
			return new Result<Boolean>(0,"未登录");
		}
		Result<Boolean> updateUserType = userservice.updateUserType(userId, userType);
		if (updateUserType != null && updateUserType.getData() == true) {
			result.setCode("1");
			result.setMessage("成功");
			result.setData(updateUserType.getData());
		}
		return result;
	} 
	
	
}
