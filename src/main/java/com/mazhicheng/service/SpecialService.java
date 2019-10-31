/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: SpecialService.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午3:52:39 
 * @version: V1.0   
 */
package com.mazhicheng.service;

import java.util.List;

import com.mazhicheng.bean.Special;

/** 
 * @ClassName: SpecialService 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午3:52:39  
 */
public interface SpecialService {

	List selspecial();

	Special selsparticle(String id);

	void addspart(String id, String text);

	List<Special> selsp();

	boolean insertspe(Special sp);

	Special updatehx(Integer id);

	boolean updatespe(Special sp);


}
