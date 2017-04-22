package com.hsy.service;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.DetailDao;
import com.hsy.daoImp.DetailDaoImp;

public class DetailService implements BaseService{

	private DetailDao detailDao=BeanFactory.getInstance(DetailDaoImp.class);
	
}
