package com.hsy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hsy.utils.PageHandel;
import com.hsy.utils.ServiceHandel;
/**
 * 前端控制器
 * @author haitang
 *
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data;
		data=ServiceHandel.ServiceHandel(request, response);   
		PageHandel.goToPage(request, response,data);
	}
	
}
