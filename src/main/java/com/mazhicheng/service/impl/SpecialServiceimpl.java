/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: SpecialServiceimpl.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.service.impl 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午3:53:03 
 * @version: V1.0   
 */
package com.mazhicheng.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhicheng.bean.Special;
import com.mazhicheng.mapper.SpecialMapper;
import com.mazhicheng.service.SpecialService;
import com.mzc.common.dateutils.StringUtils;

/** 
 * @ClassName: SpecialServiceimpl 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午3:53:03  
 */
@Service
public class SpecialServiceimpl implements SpecialService {
	
	@Autowired
	private SpecialMapper dao;
	
	
	@Override
	public List selspecial() {
		// TODO Auto-generated method stub
		return dao.selspecial();
	}


	@Override
	public Special selsparticle(String id) {
		// TODO Auto-generated method stub
		return dao.selsparticle(id);
	}


	@Override
	public void addspart(String id, String text) {
		// TODO Auto-generated method stub
		dao.addspart(id,text);
	}


	@Override
	public List<Special> selsp() {
		// TODO Auto-generated method stub
		return dao.selsp();
	}


	@Override
	public boolean insertspe(Special sp) {
		// TODO Auto-generated method stub
		
		if(StringUtils.hasText(sp.getTitle())) {
			sp.setCreated(new Date());
			dao.insertspe(sp);
			return true;
		}else {
			return false;
		}
		
	}


	@Override
	public Special updatehx(Integer id) {
		// TODO Auto-generated method stub
		return dao.updatehx(id);
	}


	@Override
	public boolean updatespe(Special sp) {
		// TODO Auto-generated method stub

		if(StringUtils.hasText(sp.getTitle())) {
			dao.updatespe(sp);
			return true;
		}else {
			return false;
		}
		
	
	}

}
