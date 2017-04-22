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
/**
 * 为每次请求和响应进行编码
 * @author haitang
 *
 */
public class EncodingFilter implements Filter {
	
	private FilterConfig fconfig;
	private String charset;
	
	/**
	 * 初始化操作
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fconfig=fConfig;
		charset=fConfig.getInitParameter("charset");
	}
	
	/**
	 * 对每次请求和响应进行编码
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//进行转化为http协议的
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		httpRequest.setCharacterEncoding(charset);
		httpResponse.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	/**
	 * 该方法通常为空
	 */
	public void destroy() {
	
	}

}
