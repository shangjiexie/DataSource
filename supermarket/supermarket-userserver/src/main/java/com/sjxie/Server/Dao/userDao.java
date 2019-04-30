package com.sjxie.Server.Dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sjxie.entity.user;


@Mapper
public interface userDao {
	user getUser(String user_id);
	
	user login(String user_name,String user_password);
	
	Boolean registerUser(String user_id,String user_name,String user_email,String user_phone,String user_password);

	List<user> getUserList();

	Integer updateMyInfo(user user);
	
	user getUserByUserName(String user_name);
	
	Boolean updateUserType(@Param("user_id")String user_id,@Param("user_type")String user_type);
	
}
