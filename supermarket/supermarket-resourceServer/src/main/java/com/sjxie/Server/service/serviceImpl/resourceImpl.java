package com.sjxie.Server.service.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjxie.Server.Dao.resourceDao;
import com.sjxie.Server.service.resourceService;
import com.sjxie.entity.cart;
import com.sjxie.entity.resource;
import com.sjxie.vo.resourceCarVo;

@Service
public class resourceImpl implements resourceService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private resourceDao resourcedao;
	
	@Override
	public List<resource> getResourceList(String resource_type) {
		List<resource> resourceList = resourcedao.getResourceList(resource_type);
		logger.info("调用地址:getResourceList;返回结果："+resourceList);
		return resourceList;
	}

	@Override
	public Integer countResource() {
		Integer resCount = resourcedao.countResource();
		logger.info("调用地址:countResource;返回结果："+resCount);
		return resCount;
	}
	
	@Override
	public Integer countResourceByType(String resource_type) {
		Integer resCount = resourcedao.countResourceByType(resource_type);
		logger.info("调用地址:countResourceByType;返回结果："+resCount);
		return resCount;
	}

	@Override
	public Integer addResource(resource res) {
		Integer addResource = resourcedao.addResource(res);
		logger.info("调用地址:addResource;返回结果："+addResource);
		return addResource;
	}

	@Override
	public Integer deleteResourceById(String resource_id) {
		Integer deleteResourceById = resourcedao.deleteResourceById(resource_id);
		logger.info("调用地址:deleteResourceById;返回结果："+deleteResourceById);
		return deleteResourceById;
	}

	@Override
	public List<resourceCarVo> getMyResourceByStatus(String user_id, Integer status) {
		List<resourceCarVo> myResourceByStatus = resourcedao.getMyResourceByStatus(user_id, status);
		logger.info("调用地址:getMyResourceByStatus;返回结果："+myResourceByStatus);
		return myResourceByStatus;
	}

	@Override
	public resource getResourceByResourceId(String resource_id) {
		resource resourceByResourceId = resourcedao.getResourceByResourceId(resource_id);
		logger.info("调用地址:getResourceByResourceId;返回结果："+resourceByResourceId);
		return resourceByResourceId;
	}

	@Override
	public Integer addCart(cart cart) {
		Integer addCart = resourcedao.addCart(cart);
		return addCart;
	}

	@Override
	public List<resource> getResourceByResourceLikeName(String resourceName) {
		List<resource> resourceByResourceLikeName = resourcedao.getResourceByResourceLikeName(resourceName);
		return resourceByResourceLikeName;
	}

	@Override
	public List<resource> getAllResourceList() {
		List<resource> allResourceList = resourcedao.getAllResourceList();
		return allResourceList;
	}

}
