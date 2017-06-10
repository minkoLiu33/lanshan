package com.lanshan.web.util;

import org.apache.commons.lang3.StringUtils;

import com.lanshan.db.User;
import com.lanshan.web.filter.ServletHolder;

public class UserHelper {
	
	/**
	 * 获取当前用户信息
	 * @author Minko
	 * @return
	 */
	public static User getUser(){
		return (User) ServletHolder.getSession().getAttribute("USER");
	}
	
	/**
	 * 保存当前用户信息
	 * @author Minko
	 * @param user
	 */
	public static void saveUser(User user){
		ServletHolder.getSession().setAttribute("USER", user);
	}
	
	/**
	 * 获取当前用户id
	 * @author Minko
	 * @return
	 */
	public static String getUserid(){
		User user = (User) ServletHolder.getSession().getAttribute("USER");
		if(user != null && StringUtils.isNotBlank(user.getId())){
			return user.getId();
		}
		return null;
	}
	
	/**
	 * 获取session属性
	 * @author Minko
	 * @param name
	 * @return
	 */
	public static Object getSessionAttr(String name){
		return ServletHolder.getSession().getAttribute(name);
	}
	
	/**
	 * 设置session属性
	 * @author Minko
	 * @param name
	 * @param value
	 */
	public static void setSessionAttr(String name, Object value){
		ServletHolder.getSession().setAttribute(name, value);
	}
	
	/**
	 * 移除session属性
	 * @author Minko
	 * @param name
	 */
	public static void removeSessionAttr(String name){
		ServletHolder.getSession().removeAttribute(name);
	}
}
