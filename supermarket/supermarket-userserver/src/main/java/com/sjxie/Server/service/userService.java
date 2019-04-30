package com.sjxie.Server.service;

import java.util.List;

import com.sjxie.dto.Result;
import com.sjxie.entity.user;

public interface userService {
	
	user getUser(String user_id);
	
	Boolean login(String user_name,String user_password);
	
	Boolean registerUer(String user_id,String user_name,String user_email,String user_phone,String user_password);
	
	List<user> getUserList();
	
	Result<Integer> updateMyInfo(user user);
	
	user getUserByUserName(String user_name);
	
	Boolean updateUserType(String user_id,String user_type);
}
