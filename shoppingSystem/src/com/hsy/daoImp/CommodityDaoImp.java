package com.hsy.daoImp;

import java.util.List;
import com.hsy.dao.CommodityDao;
import com.hsy.entity.Commodity;
import com.hsy.utils.DaoHandel;
import com.hsy.utils.Singleton;

public class CommodityDaoImp implements CommodityDao {
	
	@Override
	public boolean insert(Commodity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commodity selectById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取到所有的商品信息
	 */
	@Override
	public List<Commodity> selectAll() {
		String selectSql="select *from commodity";
		List<Commodity> list=DaoHandel.executeQueryForAll(selectSql,null,Commodity.class);
		return list;
	}

}
