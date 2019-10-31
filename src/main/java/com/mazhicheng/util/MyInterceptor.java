/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: MyInterceptor.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.util 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月24日 上午8:18:11 
 * @version: V1.0   
 */
package com.mazhicheng.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * @ClassName: MyInterceptor 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月24日 上午8:18:11  
 */
public class MyInterceptor extends HandlerInterceptorAdapter{
				@Override
				public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
						throws Exception {
					HttpSession session = request.getSession(false);
					if(session!=null) {
						Object attribute = session.getAttribute("user");
						if(attribute!=null) {
							return true;
						}
					}
					
					request.setAttribute("error", "请先登录再试");
					request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
					return false;
					
				}
}
