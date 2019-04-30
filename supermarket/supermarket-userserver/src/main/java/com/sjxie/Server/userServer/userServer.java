package com.sjxie.Server.userServer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.sjxie.Server.service.userService;
import com.sjxie.api.userApi;
import com.sjxie.dto.Result;
import com.sjxie.entity.user;

@RestController
public class userServer implements userApi {

	@Autowired
	private userService userservice;

	@Override
	public Result<user> getUser(String user_id) {

		Result<user> result = new Result<user>(1, "查询成功");
		user user = userservice.getUser(user_id);
		if (user == null) {
			result.setCode("0");
			result.setMessage("查询失败");
		}
		result.setData(user);

		return result;
	}

	@Override
	public Result<Boolean> login(String user_name, String user_password) {
		Result<Boolean> result = new Result<Boolean>(1, "登录成功");
		Boolean loginState = userservice.login(user_name, user_password);
		if (!loginState) {
			result.setCode("0");
			result.setMessage("登录失败");
		}
		return result;
	}

	@Override
	public Result<Boolean> register(String user_id, String user_name, String user_email, String user_phone,
			String user_password) {
		Result<Boolean> result = new Result<Boolean>();
		Boolean registerUerstate = userservice.registerUer(user_id, user_name, user_email, user_phone, user_password);
		if (!registerUerstate) {
			result.setCode("0");
			result.setMessage("注册用户失败");
		}
		return result;
	}

	@Override
	public Result<List<user>> getUserList(int pageNum, int pageSize) {
		Result<List<user>> result = new Result<List<user>>(1, "查询成功");
		PageHelper.startPage(pageNum, pageSize);
		List<user> userList = userservice.getUserList();
		result.setData(userList);
		return result;
	}

	@Override
	public Result<Integer> updateMyInfo(String user_id, String user_name, String user_sex, String user_age,
			String user_image, String user_email, String user_password, String user_adress, String user_type,
			String user_phone) {
		user user= new user(user_id, user_name, user_sex, user_age, user_image, user_email, user_password, user_adress, user_type, user_phone);
		Result<Integer> updateMyInfo = userservice.updateMyInfo(user);
		return updateMyInfo;
	}

	@Override
	public Result<user> getUserByUserName(String user_name) {
		Result<user> result = new Result<user>(0,"查询失败");
		user userByUserName = userservice.getUserByUserName(user_name);
		if(userByUserName != null) {
			result.setCode("0");
			result.setMessage("查询成功");
			result.setData(userByUserName);
			return result; 
		}
		return result;
	}

	@Override
	public Result<Boolean> updateUserType(String user_id,String user_type) {
		Result<Boolean> result = new Result<Boolean>(0,"失败");
		Boolean updateUserType = userservice.updateUserType(user_id, user_type);
		if(updateUserType) {
			result.setCode("1");
			result.setMessage("成功");
			result.setData(updateUserType);
		}
		return result;
	}

}
