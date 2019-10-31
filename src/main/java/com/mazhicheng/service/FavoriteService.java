/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: FavoriteService.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.service 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月29日 下午4:25:45 
 * @version: V1.0   
 */
package com.mazhicheng.service;

import java.util.List;

import com.mazhicheng.bean.Favorite;

/** 
 * @ClassName: FavoriteService 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月29日 下午4:25:45  
 */
public interface FavoriteService {

	List<Favorite> selScang(Integer id);

	void addfavorites(Favorite fav);

}
