package com.sjxie.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import com.alibaba.fastjson.JSONArray;

public class areaConstants {
	public static JSONArray CONTENT_TYPE =new JSONArray();
	@Value("classpath:provinces.json")
	private static Resource areaRes;
	
	public static JSONArray getContentType() {
		synchronized (CONTENT_TYPE) {
			if (CONTENT_TYPE.size()==0) {
			}
		}
		return CONTENT_TYPE;
	}
}
