/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: PreService.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service.impl 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月17日 下午7:44:33 
 * @version: V1.0   
 */
package com.mazhicheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhicheng.bean.User;
import com.mazhicheng.exception.CMSException;
import com.mazhicheng.mapper.UserMapper;
import com.mazhicheng.service.UserService;
import com.mazhicheng.util.Md5Util;
import com.mzc.common.dateutils.StringUtils;

/** 
 * @ClassName: PreService 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月17日 下午7:44:33  
 */
@Service
public class PreService implements com.mazhicheng.service.PreService {

	
	@Autowired
	private UserMapper dao;
	
	@Override
	public void addrep(User user, String prepassword) {
		// TODO Auto-generated method stub
		
		if(user.getUsername()==null && user.getPassword()==null) {
			throw new CMSException("用户名密码必须输入");
		}
		if(!(StringUtils.hasText(user.getUsername()))) {
			throw new CMSException("用户名不能空");
		}
		if(user.getPassword().length()<2 && user.getPassword().length()>5) {
			throw new CMSException("密码长度必须为2-5");
		}
		if(!(user.getPassword().equals(prepassword))) {
			throw new CMSException("两次密码必须一样");
		}
		String pass = Md5Util.md5Encoding(user.getPassword());
		user.setPassword(pass);
		dao.addrep(user);
	}

	@Override
	public List<User> sellogin(String username, String password) {
		// TODO Auto-generated method stub
		String pass = Md5Util.md5Encoding(password);
		List<User> selects = dao.sellogin(username,pass);
		if(selects.size()<=0) {
			throw new CMSException("用户名或密码错误");
		}else {
			User user = selects.get(0);
			if(user.getLocked()==0) {
				throw new CMSException("此用户已被冻结");
			}
		}
		return selects;
	}

}
