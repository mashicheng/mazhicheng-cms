/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: FavoriteMapper.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.mapper 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月29日 下午4:26:34 
 * @version: V1.0   
 */
package com.mazhicheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mazhicheng.bean.Favorite;

/** 
 * @ClassName: FavoriteMapper 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月29日 下午4:26:34  
 */
public interface FavoriteMapper {

	List<Favorite> selScang(@Param("id")Integer id);

	void addfavorites(Favorite fav);

}
