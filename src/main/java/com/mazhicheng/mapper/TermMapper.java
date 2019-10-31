/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: TermMapper.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.mapper 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午8:28:13 
 * @version: V1.0   
 */
package com.mazhicheng.mapper;

import org.apache.ibatis.annotations.Param;

import com.mazhicheng.bean.Term;

/** 
 * @ClassName: TermMapper 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午8:28:13  
 */
public interface TermMapper {

	void testinsert(Term term);

	Term seltermid(@Param("uniqueTerm")String uniqueTerm);

	void addartterm(@Param("id")Integer id, @Param("id2")Integer id2);

}
