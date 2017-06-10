package com.lanshan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanshan.db.User;

/**
 * 用户管理相关接口
 * @author Minko
 * 2017-06-06
 */
public interface UserMapper {
	
	/**
	 * 插入用户数据
	 * @author Minko
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 * 获取用户数据
	 * @author Minko
	 * @param user
	 * @return
	 */
	User getUser(User user);
	
	/**
	 * 用户登录
	 * @author Minko
	 * @param account
	 * @return
	 */
	User userLogin(@Param("account") String account);
	
	/**
	 * 获取用户数据集合
	 * @author Minko
	 * @param user
	 * @return
	 */
	List<User> listUser(User user);
	
	/**
	 * 更新用户数据
	 * @author Minko
	 * @param loginUser
	 */
	void updateUser(User loginUser);

}
