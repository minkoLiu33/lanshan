package com.lanshan.biz.manager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanshan.common.exception.UserException;
import com.lanshan.common.util.EmailUtil;
import com.lanshan.common.util.EncryptUtil;
import com.lanshan.common.util.SequenceUtil;
import com.lanshan.dao.UserMapper;
import com.lanshan.db.User;

/**
 * 用户管理相关业务
 * @author Minko
 * 2017-06-06
 */
@Service
public class UserManager {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登录业务
	 * @author Minko
	 * @param user
	 * @return
	 */
	public User userLogin(User user) {
		// 验证数据
		boolean validateData = (StringUtils.isBlank(user.getAccount()) 
								|| StringUtils.isBlank(user.getPassword()));
		if(validateData){
			// 抛出参数为空自定义异常
			throw new UserException("0002", "参数为空！");
		}
		// 获取用户数据
		User loginUser = userMapper.userLogin(user.getAccount());
		if(loginUser == null){
			throw new UserException("0003", "用户不存在");
		}
		if(!EncryptUtil.md5(loginUser.getPassword()).equals(EncryptUtil.md5(user.getPassword()))){
			throw new UserException("0010", "用户密码错误！");
		}
		// 更新用户数据
		userMapper.updateUser(loginUser);
		return loginUser;
	}

	/**
	 * 用户注册
	 * @author Minko
	 * @param user
	 */
	public void insert(User user) {
		// 验证数据
		boolean validateData = (StringUtils.isBlank(user.getAccount())
								|| StringUtils.isBlank(user.getPassword())
								|| StringUtils.isBlank(user.getConfirmpassword()));
		if(validateData){
			// 抛出参数为空自定义异常
			throw new UserException("0002", "参数为空！");
		}
		
		if(!user.getPassword().equals(user.getConfirmpassword())){
			throw new UserException("0011", "两次密码不一致！");
		}
		
		// 判断用户是否存在系统中
		User existUser = userMapper.userLogin(user.getAccount());
		if(existUser != null){
			throw new UserException("0004", "用户已存在！");
		}
		user.setPassword(EncryptUtil.md5(user.getPassword()));
		user.setId(SequenceUtil.getSerial());
		userMapper.insertUser(user);
		EmailUtil.send(user.getAccount());
	}
}
