/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: TermServiceimpl.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.mapper 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午8:23:45 
 * @version: V1.0   
 */
package com.mazhicheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhicheng.bean.Term;
import com.mazhicheng.mapper.TermMapper;
import com.mazhicheng.service.TermService;

/** 
 * @ClassName: TermServiceimpl 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午8:23:45  
 */
@Service
public class TermServiceimpl implements TermService{
		@Autowired
		private TermMapper dao;
		
		public void testinsert(Term term) {
			try {
				dao.testinsert(term);
				System.out.println("成功！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
