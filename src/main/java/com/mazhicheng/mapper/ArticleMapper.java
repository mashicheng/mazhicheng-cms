package com.mazhicheng.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mazhicheng.bean.Article;
import com.mazhicheng.bean.ArticleWithBLOBs;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);

	List<Article> sel_article(@Param("string")String string, @Param("hits")String hits);
	
	void updatehot(@Param("id")String id,@Param("hot")String hot);

	List<Article> sel_index(@Param("id")String id,@Param("hot") String hot);

	List<Article> sel_inzhong(@Param("id")String id);

	ArticleWithBLOBs sel_artblob(@Param("id")String id);

	void addartice(ArticleWithBLOBs art);

	List<ArticleWithBLOBs> showmyarticle(@Param("id")Integer id, @Param("tit")String tit);

	void updateartice(ArticleWithBLOBs art);

	void updcontent(@Param("id")String id, @Param("status")String stat);

	void mydelete(@Param("id")String id);

	ArticleWithBLOBs sel_artbl(@Param("id")String id);

	List<ArticleWithBLOBs> sel_hot24(@Param("time")Date time);

	List<ArticleWithBLOBs> newcontent();

	List<Article> selartal(@Param("art")Article art);

	void sel_24hot(Article art2);

	
}