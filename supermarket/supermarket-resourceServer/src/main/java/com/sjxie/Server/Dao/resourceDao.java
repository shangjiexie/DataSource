package com.sjxie.Server.Dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sjxie.entity.cart;
import com.sjxie.entity.resource;
import com.sjxie.vo.resourceCarVo;

@Mapper
public interface resourceDao {
	
	List<resource> getResourceList(String resource_type);
	
	Integer countResource();
	
	Integer countResourceByType(String resource_type);
	
	Integer addResource(resource res);
	
	Integer deleteResourceById(String resource_id);
	
	List<resourceCarVo> getMyResourceByStatus(@Param("user_id")String user_id,@Param("status")Integer status);
	
	resource getResourceByResourceId(String resource_id);
	
	Integer addCart(cart cart);
	
	List<resource> getResourceByResourceLikeName(@Param("resourceName")String resourceName);
	
	List<resource> getAllResourceList();
}
