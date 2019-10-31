/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: MyController.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.controller 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月18日 下午7:58:59 
 * @version: V1.0   
 */
package com.mazhicheng.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mazhicheng.bean.ArtVO;
import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;
import com.mazhicheng.bean.Category;
import com.mazhicheng.bean.Channel;
import com.mazhicheng.bean.Favorite;
import com.mazhicheng.bean.User;
import com.mazhicheng.exception.CMSException;
import com.mazhicheng.service.ArticleService;
import com.mazhicheng.service.ChannerService;
import com.mazhicheng.service.FavoriteService;
import com.mazhicheng.service.MyService;
import com.mazhicheng.service.UserService;
import com.mazhicheng.util.PageUtil;
import com.sun.activation.registries.MailcapFile;
import com.sun.org.apache.xpath.internal.operations.Mod;

/** 
 * @ClassName: MyController 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月18日 下午7:58:59  
 */
@RequestMapping("My")
@Controller
public class MyController {
	
	@Autowired
	private ChannerService ser;
	@Autowired
	private ArticleService sart;
	@Autowired
	private FavoriteService fart;
	@Autowired
	private UserService uuser;
	
			@RequestMapping("")
		public String goMy() {
			
			return "/my/index";
		}
			
		@RequestMapping("showaddarticle")
		public String addarticle() {
			
			return "/my/showaddarticle";
		}
		@ResponseBody
		@RequestMapping("sel_lm")
		public Object sel_lm() {
		List<Channel> sel =	ser.sel_Channer();
			
			return sel;
		}
		@ResponseBody
		@RequestMapping("sel_fl")
		public Object sel_fl(Integer id) {
			List<Category> sel =	ser.sel_heng(id);
				
				return sel;
			}
		@ResponseBody
		@RequestMapping("addartice")
		public Object addartice(ArticleWithBLOBs art,MultipartFile file) {
			if (!file.isEmpty()) {
				String path="E:/picture/";
				String originalFilename = file.getOriginalFilename();
				 String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
				 String nuwfilename = UUID.randomUUID()+substring;
				 try {
					file.transferTo(new File(path+nuwfilename));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 art.setPicture(nuwfilename);
				
			}
			art.setHits(0);
			art.setHot(0);
			art.setStatus(0);
			art.setDeleted(0);
			art.setCreated(new Date());
			art.setUpdated(new Date());
			art.setContenttype("1");
			try {
				sart.addartice(art);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		}
		
		
		@RequestMapping("showmyarticle")
		public String showmyarticle(HttpServletRequest request, Model m,Integer id,String tit,@RequestParam(defaultValue = "1")Integer page) {
			if(tit==null) {
				tit="";
			}
			if(id==null) {
				HttpSession session = request.getSession(false);
				User attribute = (User) session.getAttribute("user");
				id=attribute.getId();
			}
			PageHelper.startPage(page,5);
			List<ArticleWithBLOBs> sel =  sart.showmyarticle(id,tit);
			PageInfo pageInfo = new  PageInfo(sel);
			String page2 = PageUtil.page(page, pageInfo.getPages(),"/My/showmyarticle?tit="+tit+"&id="+id ,5);
			m.addAttribute("sel",sel);
			m.addAttribute("tit",tit);
			m.addAttribute("page",page2);
			return "/my/myarticle";
			
		}
		@RequestMapping("selmycontent")
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
				
				  return "/my/mypicart"; 
			  }else {
				  m.addAttribute("sel",sel); 
				  return "/my/mycontent"; 
			  }
			 
			 
			  
		  }
		@RequestMapping("myupdateart")
		public String myupdateart(String id,Model m) {
			ArticleWithBLOBs sel = ser.sel_artblob(id);
			m.addAttribute("content",sel);
			return "/my/myupdateart";
			}
		@ResponseBody
		@RequestMapping("updateartice")
		public Object updateartice(ArticleWithBLOBs art,MultipartFile file) {
			if (!file.isEmpty()) {
				String originalFilename = file.getOriginalFilename();
				 String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
				 String nuwfilename = UUID.randomUUID()+substring;
				 art.setPicture(nuwfilename);
			}
			art.setHits(0);
			art.setHot(0);
			art.setStatus(0);
			art.setDeleted(0);
			art.setUpdated(new Date());
			try {
				sart.updateartice(art);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		}
		@RequestMapping("mydelete")
		public String  mydelete(String id) {
			
			sart.mydelete(id);
			return "redirect:showmyarticle";
		}
		@RequestMapping("publishPic")
		public String publishPic() {
			
			
			return "/my/publishPic";
		}
		@ResponseBody
		@RequestMapping("pushpics")
		public Object pushpics(MultipartFile[] files,String[] speak,ArticleWithBLOBs art) {
			List<ArtVO> list = new ArrayList<ArtVO>();
			if(files.length>0) {
				int i=0;
				for (MultipartFile  file: files) {
					String path="E:/picture/";
					String oldname = file.getOriginalFilename();
					String substring = oldname.substring(oldname.lastIndexOf("."));
					String newname = UUID.randomUUID()+substring;
							try {
								file.transferTo(new File(path+newname));
							} catch (IllegalStateException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							art.setPicture(newname);
							ArtVO artVO = new ArtVO();
							artVO.setSpeak(speak[i]);
							artVO.setFile(newname);
							list.add(artVO);
							i++;
				}
				
			}
			Gson gson = new Gson();
			art.setContent(gson.toJson(list));
			art.setContenttype("0");
			art.setHits(0);
			art.setHot(0);
			art.setStatus(0);
			art.setDeleted(0);
			art.setCreated(new Date());
			art.setUpdated(new Date());
			try {
				sart.addartice(art);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		//收藏查询
		@RequestMapping("selScang")
		public String selScang(HttpServletRequest request,Model m) {
			HttpSession session = request.getSession(false);
			User sessUser = (User) session.getAttribute("user");
			
			List<Favorite> self =  fart.selScang(sessUser.getId());
			m.addAttribute("self",self);
			return "/my/favorite";
		}
		@RequestMapping("addfavorite")
		public String addfavorite() {
			return "/my/addfavorite";
					
		}
		
		@RequestMapping("addfavorites")
		public String addfavorites(HttpServletRequest request,Favorite fav,Model m) {
			HttpSession session = request.getSession(false);
			User sessUser = (User) session.getAttribute("user");
			fav.setCreated(new Date());
			fav.setUserId(sessUser.getId());
			try {
				fart.addfavorites(fav);
				return "redirect:selScang";
			} catch (CMSException e) {
				// TODO Auto-generated catch block
				
				m.addAttribute("error",e.getMessage());
				return "/my/addfavorite";
			}catch (Exception e) {
				// TODO Auto-generated catch block
				m.addAttribute("error","系统异常");
				return "/my/addfavorite";
			}
			
		}
		@RequestMapping("mysz")
		public String mysz(Integer id,Model m) {
			
			
			User user = uuser.seluser(id);
			m.addAttribute("user",user);
			return "/my/mySheZhi";
			
		}
		@RequestMapping("up")
		public String updateuser(String username,String birthday,String gender,String mobile,String motto,String mail,String address,String constellation,String id) {
				uuser.updateuser(username,birthday,gender,mobile,mail,address,constellation,id,motto);
				
				
				
				return "/my/index";
			
			
		}
		
		
		
		
}
