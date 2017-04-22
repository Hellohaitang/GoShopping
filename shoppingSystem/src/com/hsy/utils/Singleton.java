package com.hsy.utils;

public abstract class Singleton<T> {

	private T instance;

	/**
	 * 创建实例
	 * 
	 * @return
	 */
	protected abstract T createInstance();

	/**
	 * 返回实例
	 * 
	 * @return
	 */
	public final T getInstance() {
		synchronized (this) {
			if (null == instance) {
				instance = createInstance();
			}
		}
		return instance;
	}

}
