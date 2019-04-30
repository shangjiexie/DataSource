package com.sjxie.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.sjxie.interceptor.Authority;

@SpringBootConfiguration
public class interceptorConfig extends WebMvcConfigurationSupport{
	@Bean
    public HandlerInterceptor getMyInterceptor() {
        return new Authority();
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
 
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
