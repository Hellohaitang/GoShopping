package com.hsy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.DetailDao;
import com.hsy.daoImp.DetailDaoImp;
import com.hsy.daoImp.UserDaoImp;
import com.hsy.entity.Detail;
import com.hsy.entity.User;

import net.sf.json.JSONObject;

/**
 * 处理订单明细的service
 * 
 * @author haitang
 *
 */
public class DetailService implements BaseService {

	private DetailDao detailDao = BeanFactory.getInstance(DetailDaoImp.class);

	/**
	 * 将订单明细添加到数据库中
	 * @param request
	 * @param response
	 * @return
	 */
	public String buyShopping(HttpServletRequest request, HttpServletResponse response) {

		// 获取前端传过来的数据
		String commodityId=request.getParameter("commodityId");
		String number=request.getParameter("number");
		// 从session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("username");
		//将订单明细存储到数据库
		Detail detail=new Detail(0,user.getUserId(), Integer.parseInt(commodityId),Integer.parseInt(number));
		boolean flag = detailDao.insert(detail);
		String dataRes=(flag==true)?"1":"0";
		return dataRes;
	}

}
