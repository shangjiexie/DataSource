package com.sjxie.dto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sjxie.entity.user;

/**
 * 基础controller类
 */

public abstract class BaseController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected HttpSession getSessionData(HttpServletRequest request) {
		HttpSession session=request.getSession();
		return session;
	}

	protected void setSessionData(HttpServletRequest request,String object) {
        request.setAttribute("sessionID",object); //设置session值
        String session = (String) request.getAttribute("sessionID"); //获取session值
        System.err.println("session值为:"+session);
    }
	
	public user getLOginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		user userInfo = (user)session.getAttribute("supermarket_sessionID");
		return userInfo;
	}
	
}
