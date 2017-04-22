package com.hsy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.CommodityDao;
import com.hsy.daoImp.CommodityDaoImp;
import com.hsy.entity.Commodity;

import net.sf.json.JSONObject;

public class CommodityService implements BaseService{
	
	private CommodityDao commodityDao=BeanFactory.getInstance(CommodityDaoImp.class);
	
	/**
	 * 得到所有的商品的信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String getAllCommodity(HttpServletRequest request,HttpServletResponse response){
		//得到所有的商品信息
		List<Commodity> list=commodityDao.selectAll();
		JSONObject jsonObject=JSONObject.fromObject(list);
		return JSONObject.fromObject(jsonObject).toString();
	}
}
