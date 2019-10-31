/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: IndController.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.controller 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月18日 下午7:11:18 
 * @version: V1.0   
 */
package com.mazhicheng.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mazhicheng.bean.ArtVO;
import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;
import com.mazhicheng.bean.Category;
import com.mazhicheng.bean.Channel;
import com.mazhicheng.bean.Special;
import com.mazhicheng.service.ArticleService;
import com.mazhicheng.service.ChannerService;
import com.mazhicheng.service.SpecialService;
import com.mazhicheng.util.PageUtil;

/** 
 * @ClassName: IndController 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月18日 下午7:11:18  
 */
@RequestMapping("index")
@Controller
public class IndController {
		@Autowired
		private ChannerService ser;
		@Autowired
		private ArticleService aser;
		@Autowired
		private SpecialService sser;
		@RequestMapping(value= {"goindex",""})
		
		public String goindex(Model m,Article art,@RequestParam(defaultValue = "1")Integer page) {
			art.setDeleted(0);
			art.setContenttype("1");
			art.setStatus(1);
			
			Thread t1=null;
			Thread t2=null;
			Thread t3=null;
			Thread t4=null;
			Thread t5=null;
			Thread t6=null;
			Thread t7=null;
			
			t1= new Thread(new Runnable(){
				@Override
				public void run() {
					//查询栏目
					List<Channel> left = ser.sel_Channer();
					m.addAttribute("left",left);
				}
			});
			
			//判断栏目id是否为空 不为空查询分类
			t2 = new Thread(new Runnable() {

				@Override
				public void run() {
					if(art.getChannelId()!=null) {	
						List<Category> sel_heng = ser.sel_heng(art.getChannelId());
						m.addAttribute("heng",sel_heng);
					}else {
						art.setHot(1);
					}
				}
			});
			
			
			
			t3 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Integer cat= art.getCategoryId();
					Integer cha=art.getChannelId();
					if(cat==null) {
						cat=0;
					}
					if(cha==null) {
						cha=0;
					}
					//查询文章列表
					PageInfo selall = aser.selartall(art,page,6);
					
					String page2 = PageUtil.page(page,selall.getPages() , "/index/goindex?categoryId="+cat+"&channelId="+cha, 6);
					m.addAttribute("selall",selall.getList());
					m.addAttribute("page",page2);
					m.addAttribute("art",art);
					
				}
				
				
			});
			
			t4 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Article art2 = new Article();
					Calendar instance = Calendar.getInstance();
					instance.add(Calendar.DAY_OF_MONTH, -1);
					art2.setHot(1);
					art2.setDeleted(0);
					art2.setStatus(1);
					art2.setContenttype("1");
					art2.setCreated(instance.getTime());
					PageInfo hot24 = aser.selartall(art2,1,3);
					m.addAttribute("hot24",hot24.getList());
				}
				
			});
		
			
			t5 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Article art3 = new Article();
					art3.setDeleted(0);
					art3.setStatus(1);
					art3.setContenttype("1");
					PageInfo newhot = aser.selartall(art3,1,5);
					m.addAttribute("newhot",newhot.getList());
				}
				
				
			});
			
			t6 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Article art4 = new Article();
					art4.setDeleted(0);
					art4.setStatus(1);
					art4.setHot(1);
					art4.setContenttype("0");
					PageInfo selpics = aser.selartall(art4,1,5);
					m.addAttribute("selpics",selpics.getList());
				}
				
			});
			
			t7 = new Thread(new Runnable() {

				@Override
				public void run() {
					//专题
					List<Special> selspecial = sser.selsp();
					
					m.addAttribute("selspecial",selspecial);
				}
				
			});
			
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
			t6.start();
			t7.start();
			
			try {
				t1.join();
				t2.join();
				t3.join();
				t4.join();
				t5.join();
				t6.join();
				t7.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "/index/index";
		}
		
		@RequestMapping("sel_artblob") 
		public String sel_artblob(Model m,String id) {
			 
			  ArticleWithBLOBs sel = ser.sel_artblob(id); 
			  String contenttype = sel.getContenttype();
			  if(contenttype.equals("0")) {
				  String content = sel.getContent();
				  ArrayList<ArtVO> list = new  ArrayList<ArtVO>();
				  Gson gson = new Gson();
				  JsonArray asJsonArray = new JsonParser().parse(content).getAsJsonArray();
				  for (JsonElement jsonElement : asJsonArray) {
					  ArtVO fromJson = gson.fromJson(jsonElement,ArtVO.class);
					  list.add(fromJson);
				}
				  m.addAttribute("sel",list); 
				  m.addAttribute("id",id);
				  return "/index/picart"; 
			  }else {
				  m.addAttribute("sel",sel); 
				  return "/index/article"; 
			  }
			 
			 
			  
		  }
		
		

		
		
		
		
}
