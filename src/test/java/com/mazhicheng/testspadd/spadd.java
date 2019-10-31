/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: spadd.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.testspadd 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月30日 上午9:31:44 
 * @version: V1.0   
 */
package com.mazhicheng.testspadd;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mazhicheng.bean.Special;
import com.mazhicheng.service.SpecialService;

/** 
 * @ClassName: spadd 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月30日 上午9:31:44  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class spadd {
				@Autowired
				private SpecialService ser;
	@Test 
	public void testspadd() {
		
		Special special = new Special(null,"测试","测试测试测试测试",new Date(),null);
		
		boolean insertspe = ser.insertspe(special);
		System.out.println(insertspe);
		
	}
}
