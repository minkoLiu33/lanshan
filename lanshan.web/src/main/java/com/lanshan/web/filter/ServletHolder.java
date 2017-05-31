package com.lanshan.web.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpServletRequest
 * HttpServletResponse
 * 线程持有类
 * @author Minko
 * 2017年5月31日
 */
public class ServletHolder {
	private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();
	
	
	public static HttpServletRequest getRequest(){
		return ServletHolder.request.get();
	}
	
	public static void setRequest(HttpServletRequest request){
		ServletHolder.request.set(request);
	}
	
	public static HttpServletResponse getResponse(){
		return ServletHolder.response.get();
	}
	
	public static void setResponse(HttpServletResponse response) {
		ServletHolder.response.set(response);
	}
	
	public static HttpSession getSession(){
		return ServletHolder.request.get().getSession();
	}
	
	public static void forward(String url) {
		try {
			getRequest().getRequestDispatcher(url).forward(getRequest(), getResponse());
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
