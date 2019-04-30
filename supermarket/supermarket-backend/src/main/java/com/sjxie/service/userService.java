package com.sjxie.service;

import org.springframework.cloud.openfeign.FeignClient;
import com.sjxie.api.userApi;

@FeignClient(name = "userServer")
public interface userService extends userApi{
	
}
