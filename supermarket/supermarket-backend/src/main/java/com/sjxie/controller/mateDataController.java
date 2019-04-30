package com.sjxie.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sjxie.constants.constants;
import com.sjxie.dto.BaseController;
import com.sjxie.dto.Result;
import com.sjxie.util.StepExecutor;
import com.sjxie.util.redisTemplateUtils;

/**
 * 基础数据控制层
 * @author XieShangjie
 *
 */
@RestController
@CrossOrigin
@ResponseBody
@RequestMapping("/mateData")
public class mateDataController extends BaseController{
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private redisTemplateUtils redistemplates;
	
	/**
	 * 获取省份数据
	 * @author XieShangjie
	 * @return
	 */
	@RequestMapping("/getProvinces")
	public Result<Object> getProvinces() {
		Result<Object> result = new Result<>();
		String provinceData = redistemplates.getValueByKey("provincesObject");
		if(StringUtils.isNotEmpty(provinceData)) {
			JSONArray provinceJsonArray = JSONArray.parseArray(provinceData);
			result.setData(provinceJsonArray);
			return result;
		}
		JSONObject data = new JSONObject();
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
    	try {
    		String readFileProvinces = StepExecutor.ReadFile(path+"provinces.json").replaceAll(" ", "");
    		boolean setStringValue = redistemplates.setStringValue("provincesObject", readFileProvinces, constants.REDISDEFAULTTIME);
    		if (!setStringValue) {
    			logger.info("redis存储市数据异常！");
			} else {
    			data.put("readFileProvinces", readFileProvinces);
        		result.setData(data);
    		}
    	} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	/**
	 * 获取市数据
	 * @param provinceId 省份ID
	 * @author XieShangjie
	 * @return
	 */
	@RequestMapping("/getCity")
	public Result<Object> getCity(String provinceId) {
		Result<Object> result = new Result<>(1,"查询成功");
		String cityData = redistemplates.getValueByKey("citysObject");
		if (StringUtils.isEmpty(cityData)) {
			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
	    	try {
	    		cityData = StepExecutor.ReadFile(path+"cities.json").replaceAll(" ", "");
	    		boolean stauts = redistemplates.setStringValue("citysObject", cityData, constants.REDISDEFAULTTIME);
	    		if (!stauts) {
	    			logger.info("redis存储市数据异常！");
				}
	    	} catch (Exception e) {
				throw e;
			}	
		}
		JSONArray cityJsonArray = JSONArray.parseArray(cityData);
		JSONArray realCityArray = new JSONArray();
		for (int i = 0; i < cityJsonArray.size(); i++) {
			if(provinceId.equals(cityJsonArray.getJSONObject(i).getString("provinceCode"))) {
				realCityArray.add(cityJsonArray.getJSONObject(i));
			}
		}
		result.setData(realCityArray);
		return result;
	}
	
	/**
	 * 获取区/县数据
	 * @param cityId 市ID
	 * @author XieShangjie
	 * @return
	 */
	@RequestMapping("/getCounty")
	public Result<Object> getCounty(String cityId) {
		Result<Object> result = new Result<>();
		String countyData = redistemplates.getValueByKey("countysObject");
		if (StringUtils.isEmpty(countyData)) {
			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
	    	try {
	    		countyData = StepExecutor.ReadFile(path+"areas.json").replaceAll(" ", "");
	    		boolean stauts = redistemplates.setStringValue("countysObject", countyData, constants.REDISDEFAULTTIME);
	    		if (!stauts) {
	    			logger.info("redis存储市数据异常！");
				}
	    	} catch (Exception e) {
				throw e;
			}
		}
		JSONArray countyJsonArray = JSONArray.parseArray(countyData);
		JSONArray realCouty = new JSONArray();
		for (int i = 0; i < countyJsonArray.size(); i++) {
			if(cityId.equals(countyJsonArray.getJSONObject(i).getString("cityCode"))) {
				realCouty.add(countyJsonArray.getJSONObject(i));
			}
		}
		result.setData(realCouty);
		return result;
	}
}
