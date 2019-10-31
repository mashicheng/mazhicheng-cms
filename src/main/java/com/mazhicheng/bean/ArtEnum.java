/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArtEnum.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.bean 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月24日 下午7:11:13 
 * @version: V1.0   
 */
package com.mazhicheng.bean;

/** 
 * @ClassName: ArtEnum 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月24日 下午7:11:13  
 */
public enum ArtEnum {
			
	IMAGE(0,"image"),HTML(1,"html");
	
	
	 ArtEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
