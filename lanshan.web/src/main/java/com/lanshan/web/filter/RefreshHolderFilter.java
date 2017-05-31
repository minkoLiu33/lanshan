package com.lanshan.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshHolderFilter implements Filter {
	
	private String redirectUrl;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.redirectUrl = filterConfig.getInitParameter("redirectUrl");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String input = req.getParameter(RefreshHolder.INPUT_NAME);
		if(input != null && RefreshHolder.isRefresh(input)){
			// 重复刷新跳转
			((HttpServletResponse)response).sendRedirect(redirectUrl);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
