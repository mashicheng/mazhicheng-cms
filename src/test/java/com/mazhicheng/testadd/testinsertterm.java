package com.mazhicheng.testadd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mazhicheng.bean.Term;
import com.mazhicheng.service.TermService;
import com.mzc.common.dateutils.StringUtils;

/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: testinsertterm.java 
 * @Prject: mazhicheng-cms
 * @Package:  
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午8:09:02 
 * @version: V1.0   
 */

/** 
 * @ClassName: testinsertterm 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午8:09:02  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class testinsertterm {
			@Resource
			private TermService ser;
		
	
			@Test 
			public void testinsertterm() throws Exception {
				
				File file = new File("src/test/resources/a.txt");
				
				InputStream i = new FileInputStream(file);
				InputStreamReader in = new InputStreamReader(i);
				BufferedReader b = new BufferedReader(in);
				String readLine = b.readLine();	
				String[] split = readLine.split("\\|");
				
				for (String string : split) {
					String uniqueTerm = StringUtils.toUniqueTerm(string);
					
					Term term = new Term(null,null,uniqueTerm);
					ser.testinsert(term);
				}
				
			}
					
		
}
