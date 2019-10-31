/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CMSException.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.CMSException 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月18日 上午9:36:33 
 * @version: V1.0   
 */
package com.mazhicheng.exception;

/** 
 * @ClassName: CMSException 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月18日 上午9:36:33  
 */
public class CMSException extends RuntimeException{

	private static final long serialVersionUID = -5996345635982436853L;

	public CMSException() {
		
		
	}
	public CMSException(String massages) {
		super(massages);
	}	
	
}
