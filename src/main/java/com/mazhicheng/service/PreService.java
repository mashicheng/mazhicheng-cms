/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: PreService.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月17日 下午7:44:18 
 * @version: V1.0   
 */
package com.mazhicheng.service;

import java.util.List;

import com.mazhicheng.bean.User;

/** 
 * @ClassName: PreService 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月17日 下午7:44:18  
 */
public interface PreService {

	void addrep(User user, String prepassword);

	List<User> sellogin(String username, String password);

}
