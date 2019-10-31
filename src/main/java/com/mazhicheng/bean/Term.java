/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: Ter.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mazhicheng.bean 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午8:25:36 
 * @version: V1.0   
 */
package com.mazhicheng.bean;

import java.io.Serializable;

/** 
 * @ClassName: Ter 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午8:25:36  
 */
public class Term implements Serializable{
			private Integer id;
			private String displayName;
			private String uniqueName;
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			public String getDisplayName() {
				return displayName;
			}
			public void setDisplayName(String displayName) {
				this.displayName = displayName;
			}
			public String getUniqueName() {
				return uniqueName;
			}
			public void setUniqueName(String uniqueName) {
				this.uniqueName = uniqueName;
			}
			public Term() {
				super();
				// TODO Auto-generated constructor stub
			}
			public Term(Integer id, String displayName, String uniqueName) {
				super();
				this.id = id;
				this.displayName = displayName;
				this.uniqueName = uniqueName;
			}
			@Override
			public String toString() {
				return "Term [id=" + id + ", displayName=" + displayName + ", uniqueName=" + uniqueName + "]";
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
				result = prime * result + ((id == null) ? 0 : id.hashCode());
				result = prime * result + ((uniqueName == null) ? 0 : uniqueName.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Term other = (Term) obj;
				if (displayName == null) {
					if (other.displayName != null)
						return false;
				} else if (!displayName.equals(other.displayName))
					return false;
				if (id == null) {
					if (other.id != null)
						return false;
				} else if (!id.equals(other.id))
					return false;
				if (uniqueName == null) {
					if (other.uniqueName != null)
						return false;
				} else if (!uniqueName.equals(other.uniqueName))
					return false;
				return true;
			}
			
}
