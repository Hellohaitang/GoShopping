package com.hsy.daoImp;

import java.util.List;

import com.hsy.dao.DetailDao;
import com.hsy.entity.Detail;
import com.hsy.utils.DaoHandel;
import com.hsy.utils.Singleton;

public class DetailDaoImp implements DetailDao {

	@Override
	public boolean insert(Detail entity) {
		String insertSql="insert into detail values(null,?,?,?)";
		Object[] parameters=new Object[]{entity.getUserId(),entity.getCommodityId(),entity.getNumber()};
		boolean flag=DaoHandel.executeDML(insertSql, parameters)>0?true:false;
		return flag;
	}

	@Override
	public boolean deleteById(Object id) {
		String selectSql="delete from detail where detail_id=?";
		Object[] parameters=new Object[]{id};
		boolean flag=DaoHandel.executeDML(selectSql, parameters)>0?true:false;
		return flag;
	}
	/**
	 * 根据用户id，得到用户所有的订单明细
	 * @param id
	 * @return
	 */
	public List<Detail> selectByUserId(int id){
		String selectSql="select *from detail where user_id=?";
		Object[] parameters=new Object[]{id};
		List list=DaoHandel.executeQueryForAll(selectSql, parameters,Detail.class);
		return list;
	}
	
	
	@Override
	public Detail selectById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detail> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
