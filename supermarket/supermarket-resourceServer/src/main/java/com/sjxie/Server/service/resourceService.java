package com.sjxie.Server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sjxie.entity.cart;
import com.sjxie.entity.resource;
import com.sjxie.vo.resourceCarVo;

public interface resourceService {
	
	List<resource> getResourceList(String resource_type);
	
	Integer countResource();
	
	Integer countResourceByType(String resource_type);
	
	Integer addResource(resource res);
	
	Integer deleteResourceById(String resource_id);
	
	List<resourceCarVo> getMyResourceByStatus(String user_id,Integer status);
	
	resource getResourceByResourceId(String resource_id) ;
	
	Integer addCart(cart cart);
	
	List<resource> getResourceByResourceLikeName(String resourceName);
	
	List<resource> getAllResourceList();
}
