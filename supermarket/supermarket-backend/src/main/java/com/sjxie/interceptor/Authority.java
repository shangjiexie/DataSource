package com.sjxie.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.sjxie.entity.user;

public class Authority implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//验证是否登录
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
    	user sessionID = (user) session.getAttribute("supermarket_sessionID");
    	String requestURI = request.getRequestURI();
    	//配置白名单
    	/*if("/user/test".equals(requestURI) || "/user/login".equals(requestURI) || "/resource/uploadImage".equals(requestURI) || "/resource/addResource".equals(requestURI) || "/mateData/getProvinces".equals(requestURI)
    			|| "/mateData/getCity".equals(requestURI) || "/mateData/getCounty".equals(requestURI)) {
    		return HandlerInterceptor.super.preHandle(request, response, handler);
    	}*/
    	if(true) {
    		return HandlerInterceptor.super.preHandle(request, response, handler);
    	}
    	/*if(sessionID == null) {
    		Result<String> result = new Result<String>(0,"请先登录");
    		PrintWriter writer = null;
    		writer = response.getWriter();
    		result.setCode("3");
    		writer.print(result);
    		return false;
    	}*/
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
 
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
 
    }
}
