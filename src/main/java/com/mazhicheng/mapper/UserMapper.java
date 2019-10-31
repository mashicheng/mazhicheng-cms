package com.mazhicheng.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mazhicheng.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> sel_users(@Param("username")String username);

	void updatelocked(@Param("id")String id,@Param("locked") String locked);

	void addrep(User user);

	List<User> sellogin(@Param("username")String username, @Param("password")String password);

	User seluser(@Param("id")Integer id);

	void updateuser(User user);

	void updateuser(@Param("date")Date date, @Param("username")String username, @Param("birthday")String birthday, @Param("gender")String gender, @Param("mobile")String mobile, @Param("mail")String mail, @Param("address")String address,
			@Param("constellation")String constellation, @Param("id")String id, @Param("motto")String motto);
}