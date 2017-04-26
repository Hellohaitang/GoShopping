package com.gwy.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 将数据写入到response
 * 
 * @author haitang
 *
 */
public class PageHandel {

	/**
	 * 将数据写入到response
	 * 
	 * @param request
	 * @param response
	 * @param data
	 * @throws IOException
	 * @throws ServletException
	 */
	public static void goToPage(HttpServletRequest request, HttpServletResponse response, String data) throws IOException{

		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(data);
		writer.flush();
	}
}
