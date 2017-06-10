package com.lanshan.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * @author ticker
 * 2016年1月31日
 */
public class CookieUtil {
	
	/**
	 * 获取cookie值
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getValue(HttpServletRequest request, String name) {
		String value = "";
		Cookie cookie = getCookie(request, name);
		if (cookie != null) {
			value = cookie.getValue();
		}
		return value;
	}
	
	/**
	 * 获取Cookie对象
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookie(HttpServletRequest request, String name){
		Cookie c = null;
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					c = cookie;
					break;
				}
			}
		}
		return c;
	}
	
	/**
	 * 设置Cookie对象
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @param expire
	 */
	public static void setCookie(HttpServletRequest request, HttpServletResponse response, 
			String name, String value, int expire) {

		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(".ufubank.com");
		cookie.setPath("/");
		cookie.setMaxAge(expire);
		response.addCookie(cookie);
	}

	/**
	 * 清除Cookie对象
	 * @param request
	 * @param response
	 * @param name
	 */
	public static void removeCookie(HttpServletRequest request, HttpServletResponse response,
			String name) {
		Cookie cookie = new Cookie(name, "");
		cookie.setDomain(".lanshan.com");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
