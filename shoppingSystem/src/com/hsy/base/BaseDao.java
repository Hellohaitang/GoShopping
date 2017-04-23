package com.hsy.base;

import java.util.List;

/**
 * 所有的Dao都要实现的接口
 * @author haitang
 *
 * @param <T>
 */
public interface BaseDao<T> {
   
	/**
	 * 插入数据到表中
	 * @param entity
	 */
	int insert(T entity);
	
	/**
	 * 根据id删除表中的记录
	 * @param id
	 */
	int deleteById(Object id);
	
	/**
	 * 根据id查找表中的记录
	 * @param id
	 * @return
	 */
	T selectById(Object id);
	
	/**
	 * 查找表所有的记录
	 * @return
	 */
	List<T> selectAll();
}
