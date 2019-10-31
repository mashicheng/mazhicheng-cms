/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: SpecialMapper.java 
 * @Prject: mazhicheng-cms
 * @Package: SpecialMapper 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午3:44:41 
 * @version: V1.0   
 */
package com.mazhicheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mazhicheng.bean.Special;

/** 
 * @ClassName: SpecialMapper 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午3:44:41  
 */
public interface SpecialMapper {

	List selspecial();

	Special selsparticle(@Param("id")String id);

	void addspart(@Param("id")String id,@Param("text") String text);

	List<Special> selsp();

	void insertspe(Special sp);

	Special updatehx(@Param("id")Integer id);

	void updatespe(Special sp);
			
}
