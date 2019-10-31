/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleService.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月17日 下午2:19:21 
 * @version: V1.0   
 */
package com.mazhicheng.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;

/** 
 * @ClassName: ArticleService 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月17日 下午2:19:21  
 */
public interface ArticleService {

	PageInfo sel_article(String string, String hits, Integer page);

	void updatehot(String id, String hot);

	void addartice(ArticleWithBLOBs art);

	List<ArticleWithBLOBs> showmyarticle(Integer id, String tit);

	void updateartice(ArticleWithBLOBs art);

	void updcontent(String id, String stat);

	void mydelete(String id);

	List<ArticleWithBLOBs> sel_hot24();

	List<ArticleWithBLOBs> newcontent();

	PageInfo selartall(Article art, Integer page, int i);




	

}
