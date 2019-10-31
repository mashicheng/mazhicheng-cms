/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: RepController.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.controller 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月17日 下午7:43:35 
 * @version: V1.0   
 */
package com.mazhicheng.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;
import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.Category;
import com.mazhicheng.bean.Channel;
import com.mazhicheng.bean.User;
import com.mazhicheng.exception.CMSException;
import com.mazhicheng.service.ArticleService;
import com.mazhicheng.service.ChannerService;
import com.mazhicheng.service.PreService;
import com.mazhicheng.util.PageUtil;

/** 
 * @ClassName: RepController 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月17日 下午7:43:35  
 */
@RequestMapping("rep")
@Controller
public class RepController {
	
	
	@Autowired
	private PreService ser;
	@Autowired
	private ChannerService cser;
	@Autowired
	private ArticleService aser;
	@RequestMapping(value={"gorep","","/"})
	public String gopre() {
		
		return "/login/rep";
	}
	@RequestMapping(value={"login"})
	public String login() {
		
		return "/login/login";
	}
	
	@RequestMapping("addrep")
	public String addrep(Model m,User user,String prepassword,RedirectAttributes red) {
		
		try {
			user.setLocked(1);
			user.setRole("0");
			user.setCreated(new Date());
			user.setUpdated(new Date());
			ser.addrep(user,prepassword);
			red.addFlashAttribute("repname",user.getUsername());
			return "redirect:login";
		} catch (CMSException cms) {
			cms.printStackTrace();
			m.addAttribute("error",cms.getMessage());
			return "login/rep";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("error","系统错误请与管理员联系");
			return "login/rep";
		}
	}
	
	
	@RequestMapping("gologin")
	public String gologin(Model m,String username,String password,HttpServletRequest requirest) {
		
		try {
			List<User> selects = ser.sellogin(username,password);
			User user = selects.get(0);
			
			if(user.getRole().equals("1")) {
			
					HttpSession session = requirest.getSession();
					session.setAttribute("admin", user);
					return "/host/index";
				
			}else {
				
					HttpSession session = requirest.getSession();
					session.setAttribute("user", user);
					return "redirect:/index/goindex";
				
			}
			
		} catch (CMSException cms) {
			// TODO Auto-generated catch block
			cms.printStackTrace();
			m.addAttribute("error",cms.getMessage());
			return "/login/login";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("error","系统错误，请与管理员联系");
			return "/login/login";
		}
		
	
	}
	@GetMapping("loginout")
	public String loginout(HttpServletRequest requirest) {
		HttpSession session = requirest.getSession(false);
		if(null==session) {
			return "/login/login";
		}
		session.invalidate();
		return "/login/login";
	}
	
	
}
