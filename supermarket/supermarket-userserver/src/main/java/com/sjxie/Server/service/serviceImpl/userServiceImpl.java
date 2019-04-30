package com.sjxie.Server.service.serviceImpl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjxie.Server.Dao.userDao;
import com.sjxie.Server.service.userService;
import com.sjxie.dto.Result;
import com.sjxie.entity.user;

@Service
public class userServiceImpl implements userService{

	@Autowired
	private userDao userdao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public user getUser(String user_id) {
		return userdao.getUser(user_id);
	}

	@Override
	public Boolean login(String user_name, String user_password) {
		user user = userdao.login(user_name, user_password);
		logger.info("调用地址:login;返回结果："+user);
		if(user != null) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean registerUer(String user_id,String user_name,String user_email,String user_phone,String user_password) {
		logger.info("调用地址:updateMyInfo;参数："+user_id,user_name,user_email,user_phone,user_password);
		Boolean registerUserstate = userdao.registerUser(user_id,user_name,user_email,user_phone,user_password);
		logger.info("调用地址:registerUer;返回结果："+registerUserstate);
		if(registerUserstate) {
			return true;
		}
		return false;
	}

	@Override
	public List<user> getUserList() {
		logger.info("调用地址:updateMyInfo;参数：");
		List<user> userList = userdao.getUserList();
		logger.info("调用地址:getUserList;返回结果："+userList);
		if(CollectionUtils.isEmpty(userList)) {
			return null;
		}
		return userList;
	}

	@Override
	public Result<Integer> updateMyInfo(user user) {
		Result<Integer> result  = new Result<Integer>();
		logger.info("调用地址:updateMyInfo;参数："+user.toString());
		Integer updateMyInfo = userdao.updateMyInfo(user);
		logger.info("调用地址:updateMyInfo;返回结果："+updateMyInfo);
		result.setData(updateMyInfo);
		return result;
	}

	@Override
	public user getUserByUserName(String user_name) {
		user userByUserName = userdao.getUserByUserName(user_name);
		return userByUserName;
	}

	@Override
	public Boolean updateUserType(String user_id,String user_type) {
		Boolean updateUserType = userdao.updateUserType(user_id,user_type);
		return updateUserType;
	}

}
