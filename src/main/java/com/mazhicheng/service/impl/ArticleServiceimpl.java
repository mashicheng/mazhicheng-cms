/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleServiceimpl.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service.impl 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月17日 下午2:19:51 
 * @version: V1.0   
 */
package com.mazhicheng.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;
import com.mazhicheng.bean.Term;
import com.mazhicheng.mapper.ArticleMapper;
import com.mazhicheng.mapper.TermMapper;
import com.mazhicheng.service.ArticleService;
import com.mzc.common.dateutils.StringUtils;

/** 
 * @ClassName: ArticleServiceimpl 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月17日 下午2:19:51  
 */
@Service 
public class ArticleServiceimpl implements ArticleService {

	@Autowired
	private ArticleMapper dao;
	@Autowired
	private TermMapper tdao;
	@Override
	public PageInfo sel_article(String string, String hits, Integer page) {
		// TODO Auto-generated method stub
		Page startPage = PageHelper.startPage(page,3);
		List<Article> sel_article = dao.sel_article(string,hits);
	
		return new PageInfo(sel_article);
	}
	@Override
	public void updatehot(String id, String hot) {
		// TODO Auto-generated method stub
		dao.updatehot(id,hot);
	}
	
	@Override
	public void addartice(ArticleWithBLOBs art) {
		// TODO Auto-generated method stub
		dao.addartice(art);
		String term = art.getTerm();
		String[] split = term.split(",");
		for (String string : split) {
			String uniqueTerm = StringUtils.toUniqueTerm(string);
			Term t = tdao.seltermid(uniqueTerm);
			if(null==t) {
				t = new Term(null,null,uniqueTerm);
				tdao.testinsert(t);
				tdao.addartterm(art.getId(),t.getId());
			}else {
				tdao.addartterm(art.getId(),t.getId());
			}
			
		}
		
	}

	@Override
	public List<ArticleWithBLOBs> showmyarticle(Integer id,String tit) {
		// TODO Auto-generated method stub
		return dao.showmyarticle(id,tit);
	}
	@Override
	public void updateartice(ArticleWithBLOBs art) {
		// TODO Auto-generated method stub
		dao.updateartice(art);
	}
	@Override
	public void updcontent(String id, String stat) {
		// TODO Auto-generated method stub
		dao.updcontent(id,stat);
	}
	@Override
	public void mydelete(String id) {
		// TODO Auto-generated method stub
		dao.mydelete(id);
	}
	@Override
	public List<ArticleWithBLOBs> sel_hot24() {
		// TODO Auto-generated method stub
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, -1);
		
		return dao.sel_hot24(instance.getTime());
	}
	@Override
	public List<ArticleWithBLOBs> newcontent() {
		// TODO Auto-generated method stub
		return dao.newcontent();
	}
	@Override
	public PageInfo selartall(Article art, Integer page,int i) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,i);
		List<Article> list = dao.selartal(art);
		PageInfo info = new PageInfo(list);
		
		return info;
	}
	
	

}
