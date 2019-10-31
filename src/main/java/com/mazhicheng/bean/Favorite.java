/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: Favorite.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.controller 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月29日 下午4:28:15 
 * @version: V1.0   
 */
package com.mazhicheng.bean;

import java.util.Date;

/** 
 * @ClassName: Favorite 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月29日 下午4:28:15  
 */
/** 
 * @ClassName: Favorite 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月29日 下午7:04:32  
 */
public class Favorite {
	
				private Integer id;
				private String text;
				private String url;
				private Integer userId;
				private Date created;
				public Integer getId() {
					return id;
				}
				public void setId(Integer id) {
					this.id = id;
				}
				public String getText() {
					return text;
				}
				public void setText(String text) {
					this.text = text;
				}
				public String getUrl() {
					return url;
				}
				public void setUrl(String url) {
					this.url = url;
				}
				public Integer getUserId() {
					return userId;
				}
				public void setUserId(Integer userId) {
					this.userId = userId;
				}
				public Date getCreated() {
					return created;
				}
				public void setCreated(Date created) {
					this.created = created;
				}
				
	}
