/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ChannerService.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月18日 下午7:26:58 
 * @version: V1.0   
 */
package com.mazhicheng.service;

import java.util.List;

import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;
import com.mazhicheng.bean.Category;
import com.mazhicheng.bean.Channel;

/** 
 * @ClassName: ChannerService 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月18日 下午7:26:58  
 */
public interface ChannerService {

	List<Channel> sel_Channer();




	ArticleWithBLOBs sel_artblob(String id);

	ArticleWithBLOBs sel_artbl(String id);




	List<Category> sel_heng(Integer channelId);

	

}
