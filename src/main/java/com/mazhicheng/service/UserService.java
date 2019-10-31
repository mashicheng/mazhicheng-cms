/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CmsService.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月16日 上午10:50:19 
 * @version: V1.0   
 */
package com.mazhicheng.service;

import java.util.List;

import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.User;

/** 
 * @ClassName: CmsService 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月16日 上午10:50:19  
 */
public interface UserService {

	List<User> sel_users(String username);

	void updatelocked(String id, String locked);

	User seluser(Integer id);


	void updateuser(String username, String birthday, String gender, String mobile, String mail, String address,
			String constellation, String id, String motto);

	

	

}
