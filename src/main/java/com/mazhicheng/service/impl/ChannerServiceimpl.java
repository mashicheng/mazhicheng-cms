/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ChannerServiceimpl.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service.impl 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月18日 下午7:27:12 
 * @version: V1.0   
 */
package com.mazhicheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;
import com.mazhicheng.bean.Category;
import com.mazhicheng.bean.Channel;
import com.mazhicheng.mapper.ArticleMapper;
import com.mazhicheng.mapper.CategoryMapper;
import com.mazhicheng.mapper.ChannelMapper;
import com.mazhicheng.service.ChannerService;

/** 
 * @ClassName: ChannerServiceimpl 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月18日 下午7:27:12  
 */
@Service
public class ChannerServiceimpl implements ChannerService {
	@Autowired
	private ChannelMapper dao;
	@Autowired
	private CategoryMapper cdao;
	@Autowired
	private ArticleMapper adao;
	@Override
	public List<Channel> sel_Channer() {
		// TODO Auto-generated method stub
		return dao.sel_Channel();
	}

	@Override
	public List<Category> sel_heng(Integer id) {
		// TODO Auto-generated method stub
		return cdao.sel_heng(id);
	}

	
	@Override
	public ArticleWithBLOBs sel_artblob(String id) {
		// TODO Auto-generated method stub
		return adao.sel_artblob(id);
	}

	@Override
	public ArticleWithBLOBs sel_artbl(String id) {
		// TODO Auto-generated method stub
		return adao.sel_artbl(id);
	}

	

}
