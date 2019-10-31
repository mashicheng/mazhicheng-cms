package com.mazhicheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mazhicheng.bean.Category;
import com.mazhicheng.bean.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

	List<Channel> sel_Channel();

	

	
}