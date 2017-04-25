package com.hsy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

/**
 * 验证用户的权限
 * 
 * @author haitang
 *
 */
public class SessionCheckFilter implements Filter {

	private FilterConfig fConfig;
	private String redirectURL;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 进行转化为http协议的
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		// 获取请求的uri
		String url = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		String uri = url.substring(contextPath.length(), url.length());
		// 如果请求不是是来自登录页面和注册页面
		String method=httpRequest.getParameter("method");
		
		if (method != null && !method.equals("login") && !method.equals("register")){

			// 如果用户请求的既不是登录页面也不是注册的页面
			if (!uri.equals(redirectURL)) {

				// 检验用户是否登录过
				String username = null;
				username = (String) session.getAttribute("username");
				// 如果用户还没有登录
				if (username == null) {
					httpResponse.sendRedirect(contextPath + "" + redirectURL);
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * 初始化操作
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		redirectURL = fConfig.getInitParameter("redirectURL");
	}

	/**
	 * 什么都不做
	 */
	public void destroy() {
	}
}
