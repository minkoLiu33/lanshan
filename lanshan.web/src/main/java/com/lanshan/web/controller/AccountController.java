package com.lanshan.web.controller;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanshan.biz.manager.UserManager;
import com.lanshan.common.exception.UserException;
import com.lanshan.db.User;
import com.lanshan.web.filter.ServletHolder;
import com.lanshan.web.util.CookieUtil;
import com.lanshan.web.util.UserHelper;

/**
 * 用户账户controller
 * @author Minko
 *
 */
@Controller
@Slf4j
@RequestMapping(value = "account")
public class AccountController {
	
	@Autowired
	private UserManager userManager;
	
	/**
	 * 用户登录
	 * @author Minko
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/signin")
	@ResponseBody
	public Map<String, Object> userSignIn(User user){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		log.info("user login action param: account={}", user.getAccount());
		User loginUser = new User();
		try {
			loginUser = userManager.userLogin(user);
		} catch(UserException ue){
			log.error(ue.getMessage());
			resultMap.put("errCode", ue.getCode());
			resultMap.put("errMsg", ue.getMessage());
			return resultMap;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			resultMap.put("errCode", "9999");
			resultMap.put("errMsg", "系统出现异常！");
			return resultMap;
		}
		// 设置cookie, 保存默认访问站点
		UserHelper.saveUser(loginUser);
		CookieUtil.setCookie(ServletHolder.getRequest(), ServletHolder.getResponse(), "site", "1" , 365*24*3600);
		resultMap.put("errCode", "0000");
		return resultMap;
	}
	
	/**
	 * 用户注册
	 * @author Minko
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/signup")
	@ResponseBody
	public Map<String, Object> userSignUp(User user){
		log.info("user sign up action param: account={}", user.getAccount());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userManager.insert(user);
		}  catch(UserException ue){
			log.error(ue.getMessage());
			resultMap.put("errCode", ue.getCode());
			resultMap.put("errMsg", ue.getMessage());
			return resultMap;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			resultMap.put("errCode", "9999");
			resultMap.put("errMsg", "系统出现异常！");
			return resultMap;
		}
		resultMap.put("errCode", "0000");
		return resultMap;
	}
	
	
}
