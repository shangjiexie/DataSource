package com.sjxie.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import com.sjxie.constants.constants;


@Component
public class StepExecutor implements Runnable  {
	@Autowired
	private redisTemplateUtils redistemplates;
	
    @Value("classpath:provinces.json")
    private Resource resource;
    
    @Override
    public void run() {
    	String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
    	try {
    		String readFileProvinces = StepExecutor.ReadFile(path+"provinces.json").replaceAll(" ", "");
    		//JSONArray provincesArray = JSONArray.parseArray(readFileProvinces);
    		String readFileCity = StepExecutor.ReadFile(path+"cities.json").replaceAll(" ", "");
    		//JSONArray citysArray = JSONArray.parseArray(readFileCity);
    		String readFileCounty = StepExecutor.ReadFile(path+"areas.json").replaceAll(" ", "");
    		System.out.println(readFileProvinces);
    		System.out.println(readFileCity);
    		System.out.println(readFileCounty);
    		//JSONArray countyArray = JSONArray.parseArray(readFileCounty);
    		redistemplates.setStringValue("provincesObject", "test", constants.REDISDEFAULTTIME);
    		//redistemplates.setStringValue("citysObject", readFileCity, constants.REDISDEFAULTTIME);
    		//redistemplates.setStringValue("countysObject", readFileCounty, constants.REDISDEFAULTTIME);
		} catch (Exception e) {
			throw e;
		}
    }

    public static String ReadFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
}