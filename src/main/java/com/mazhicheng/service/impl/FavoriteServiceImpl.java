/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: FavoriteServiceImpl.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.service.impl 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月29日 下午4:25:55 
 * @version: V1.0   
 */
package com.mazhicheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhicheng.bean.Favorite;
import com.mazhicheng.exception.CMSException;
import com.mazhicheng.mapper.FavoriteMapper;
import com.mazhicheng.service.FavoriteService;
import com.mzc.common.dateutils.StringUtils;

/** 
 * @ClassName: FavoriteServiceImpl 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月29日 下午4:25:55  
 */
@Service
public class FavoriteServiceImpl implements FavoriteService{
		@Autowired
		private FavoriteMapper dao;

		@Override
		public List<Favorite> selScang(Integer id) {
			// TODO Auto-generated method stub
			return dao.selScang(id);
		}

		@Override
		public void addfavorites(Favorite fav) {
			// TODO Auto-generated method stub
			boolean uri = StringUtils.toUri(fav.getUrl());
			if(uri) {
				dao.addfavorites(fav);
			}else {
				throw new CMSException("请输入有效链接");
			}
		}
		
		
}
