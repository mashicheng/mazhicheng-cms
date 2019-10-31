/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CmsServiceimpl.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service.impl 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月16日 上午10:51:33 
 * @version: V1.0   
 */
package com.mazhicheng.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhicheng.bean.User;
import com.mazhicheng.mapper.UserMapper;
import com.mazhicheng.service.UserService;

/** 
 * @ClassName: CmsServiceimpl 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月16日 上午10:51:33  
 */
@Service
public class UserServiceimpl implements UserService{
				
				@Autowired
				private UserMapper userMapper;
				
				
				@Override
				public List<User> sel_users(String username) {
					// TODO Auto-generated method stub
					return userMapper.sel_users(username);
				}


				@Override
				public void updatelocked(String id, String locked) {
					// TODO Auto-generated method stub
					userMapper.updatelocked(id,locked);
				}


				@Override
				public User seluser(Integer id) {
					// TODO Auto-generated method stub
					return userMapper.seluser(id);
				}


			


				@Override
				public void updateuser(String username, String birthday, String gender, String mobile, String mail,
						String address, String constellation,String id,String motto) {
					// TODO Auto-generated method stub
					userMapper.updateuser(new Date(),username,birthday,gender,mobile,mail,address,constellation,id,motto);
				}
			
					
	
	
}
