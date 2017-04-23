package com.hsy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.CommodityDao;
import com.hsy.daoImp.CommodityDaoImp;
import com.hsy.entity.Commodity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CommodityService implements BaseService {

	private CommodityDao commodityDao = BeanFactory.getInstance(CommodityDaoImp.class);

	/**
	 * 得到所有的商品的信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String getAllCommodity(HttpServletRequest request, HttpServletResponse response) {
		// 得到所有的商品信息
		List<Commodity> list = commodityDao.selectAll();
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}

	/**
	 * 得到指定分类的商品的信息 
	 * 女装，男装，女鞋，男鞋，鲜花，零食
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String getAllCommodityByClassName(HttpServletRequest request, HttpServletResponse response) {
		
		String className=request.getParameter("className");
		// 得到所有的商品信息
		List<Commodity> list = commodityDao.getAllCommodityByClassName(className);
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	public static void main(String[] args) {
		CommodityService commodityService=new CommodityService();
		System.out.println(commodityService.getAllCommodityByClassName(null, null));
		System.out.println(commodityService.getAllCommodity(null, null));
	}
}
