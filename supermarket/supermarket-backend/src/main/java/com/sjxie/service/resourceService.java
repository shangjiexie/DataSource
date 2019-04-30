package com.sjxie.service;

import org.springframework.cloud.openfeign.FeignClient;
import resourceApi.resourceApi;

@FeignClient(name = "resourceServer")
public interface resourceService extends resourceApi{
	
}
