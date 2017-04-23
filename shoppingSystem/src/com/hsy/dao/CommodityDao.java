package com.hsy.dao;

import java.util.List;

import com.hsy.base.BaseDao;
import com.hsy.entity.Commodity;

public interface CommodityDao extends BaseDao<Commodity>{

	/**
	 * 修改商品的数量
	 * @param commodityId
	 * @param number
	 * @return
	 */
	int updateCommodityById(int commodityId,int number);
	
	/**
	 * 得到指定分类的商品的信息 
	 * 女装，男装，女鞋，男鞋，鲜花，零食
	 * @param className
	 * @return
	 */
	List<Commodity> getAllCommodityByClassName(String className);
}
