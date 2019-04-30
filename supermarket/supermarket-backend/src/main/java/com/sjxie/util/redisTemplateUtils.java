package com.sjxie.util;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class redisTemplateUtils {
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    //存对象类型
    public boolean setObjectValue(String key,Object value,Long outTime) {
    	boolean result = false;
    	 try {
    		 redisTemplate.opsForValue().set(key, value);
    		 if(outTime != null) {
    			 redisTemplate.expire(key, outTime, TimeUnit.SECONDS); 
    		 }
             result = true;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return result;
    }
    
    //存字符串类型
    public boolean setStringValue(String key,String value,Long outTime) {
    	boolean result = false;
    	 try {
    		 stringRedisTemplate.opsForValue().set(key, value);
    		 if(outTime != null) {
    			 redisTemplate.expire(key, outTime, TimeUnit.SECONDS); 
    		 }
             result = true;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return result;
    }
    
    //取
    public String getValueByKey(String key) {
    	String value = stringRedisTemplate.opsForValue().get(key); 
    	return value;
    }
    
}
