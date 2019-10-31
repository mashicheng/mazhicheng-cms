/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CmsController.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.controller 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月16日 上午8:26:35 
 * @version: V1.0   
 */
package com.mazhicheng.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;
import com.mazhicheng.bean.Special;
import com.mazhicheng.bean.User;
import com.mazhicheng.service.ArticleService;
import com.mazhicheng.service.ChannerService;
import com.mazhicheng.service.SpecialService;
import com.mazhicheng.service.UserService;
import com.mazhicheng.util.PageUtil;

/** 
 * @ClassName: CmsController 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月16日 上午8:26:35  
 */
@RequestMapping("admin")
@Controller
public class CmsController {
			@Autowired
			private UserService ser;
			@Autowired 
			private ArticleService aser; 
			@Autowired 
			private ChannerService cser; 
			@Autowired
			private SpecialService sser;
			
			@RequestMapping(value = {"index",""})
			public String selects() {
				
				return "host/index";
				
			}
			@GetMapping("sel_users")
			public String sel_users(Model m,String username,@RequestParam(defaultValue = "1")Integer page) {
				if(username==null) {
					username="";
				}
				Page startPage = PageHelper.startPage(page,3);
				List<User> select = ser.sel_users(username);
				PageInfo pageInfo = new PageInfo(select);
				PageUtil pageUtil = new PageUtil();
				
				String page2 = PageUtil.page(page,pageInfo.getPages() ,"/admin/sel_users?username="+username , 3);
				m.addAttribute("select", select);
				m.addAttribute("username",username);
				m.addAttribute("page",page2);
				return "host/users";
			}
			@ResponseBody
			@RequestMapping("updatelocked")
			public Object updatelocked(String id,String locked) {
				
				 try {
					ser.updatelocked(id,locked);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			
				
			}
			
			@RequestMapping("sel_article")
			public String sel_article(Model m,String string,String hits,@RequestParam(defaultValue = "1")Integer page) {
				if(string==null) {
					string="";
				}
				if(hits==null) {
					hits="0";
				}
				PageInfo select = aser.sel_article(string,hits,page);
				
				String page2 = PageUtil.page(page, select.getPages(),"/admin/sel_article?string="+string+"&hits="+hits , 3);
				m.addAttribute("aselect",select.getList());
				m.addAttribute("page",page2);
				m.addAttribute("string",string);
				return "host/articless";
			}
			@ResponseBody
			@RequestMapping("updatehot")
			public Object updatehot(String id,String hot) {
				try {
					aser.updatehot(id,hot);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
			}
			@RequestMapping("sel_status")
			public String sel_status(Model m,String id) {
				
				ArticleWithBLOBs sel = cser.sel_artbl(id);
				m.addAttribute("content",sel);
				
				return "/host/chontent";
				
			}
			@ResponseBody
			@RequestMapping("updcontent")
			public Object updcontent(String id,String stat) {
				
				try {
					aser.updcontent(id,stat);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
			
			}
			@RequestMapping("selspecial")
			public String selspecial(Model m) {
				List selcount = sser.selspecial();
				m.addAttribute("selcount",selcount);
				return "/host/selspecial";
			}
			@RequestMapping("selsparticle")
			public String selsparticle(String id,Model m) {
				
				Special selspecial = sser.selsparticle(id);
				for (Article iterable_element : selspecial.getArticle()) {
					System.out.println(iterable_element.getTitle());
				}
				m.addAttribute("selspecial",selspecial);
				return "/host/addspecialart";
				
			}
			@ResponseBody
			@RequestMapping("addspart")
			public boolean addspart(String id,String text) {
				try {
					sser.addspart(id,text);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
			}
			@RequestMapping("insertspecial")
			public String insertspecial() {
				
				
				return "/host/insertspecial";
			}
			@ResponseBody
			@RequestMapping("insertspe")
			public boolean insertspe(Special sp) {
				
				
					boolean inser =  sser.insertspe(sp);
					return inser;
				
			}
			@RequestMapping("updatehx")
			public String updatehx(Integer id,Model m) {
				
				Special s = sser.updatehx(id);
				m.addAttribute("special",s);
				return "/host/updatespecial" ;
			}
			@ResponseBody
 			@RequestMapping("updatespe")
			public boolean updatespe(Special sp) {
				
				
				boolean inser =  sser.updatespe(sp);
				return inser;
			
		}
			
			
 			
}
