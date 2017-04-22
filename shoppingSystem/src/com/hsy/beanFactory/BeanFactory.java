package com.hsy.beanFactory;

/**
 * 通过反射来生产类的实例
 * @author haitang
 *
 */
public class BeanFactory {
	
	/**
	 * 生产Bean
	 * @param clazz
	 * @return
	 */
	public static <T> T getInstance(Class<T> clazz){
		T instance=null;
		try {
			instance = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return instance;
	}
}
