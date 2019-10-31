/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: Special.java 
 * @Prject: mazhicheng-cms
 * @Package: com.mzc.bean 
 * @Description: TODO
 * @author: 马志成  
 * @date: 2019年10月27日 下午3:37:58 
 * @version: V1.0   
 */
package com.mazhicheng.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
 * @ClassName: Special 
 * @Description: TODO
 * @author:马志成 
 * @date: 2019年10月27日 下午3:37:58  
 */
public class Special implements Serializable{
		private Integer id;
		private String title;
		private String abstrac;
		private Date  created;
		private List<Article> article;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAbstrac() {
			return abstrac;
		}
		public void setAbstrac(String abstrac) {
			this.abstrac = abstrac;
		}
		public Date getCreated() {
			return created;
		}
		public void setCreated(Date created) {
			this.created = created;
		}
		public List<Article> getArticle() {
			return article;
		}
		public void setArticle(List<Article> article) {
			this.article = article;
		}
		public Special() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Special(Integer id, String title, String abstrac, Date created, List<Article> article) {
			super();
			this.id = id;
			this.title = title;
			this.abstrac = abstrac;
			this.created = created;
			this.article = article;
		}
		@Override
		public String toString() {
			return "Special [id=" + id + ", title=" + title + ", abstrac=" + abstrac + ", created=" + created
					+ ", article=" + article + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((abstrac == null) ? 0 : abstrac.hashCode());
			result = prime * result + ((article == null) ? 0 : article.hashCode());
			result = prime * result + ((created == null) ? 0 : created.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
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
			Special other = (Special) obj;
			if (abstrac == null) {
				if (other.abstrac != null)
					return false;
			} else if (!abstrac.equals(other.abstrac))
				return false;
			if (article == null) {
				if (other.article != null)
					return false;
			} else if (!article.equals(other.article))
				return false;
			if (created == null) {
				if (other.created != null)
					return false;
			} else if (!created.equals(other.created))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}
		
	
		
		
		
}
