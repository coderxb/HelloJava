package com.china.gavin.javabase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecurityHandler implements InvocationHandler {

	private Object targetObj;

	/**
	 * 代理类声明
	 */
	public Object newProxy(Object targetObj) {
		this.targetObj = targetObj;
		return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),
				targetObj.getClass().getInterfaces(), this);

	}

	/**
	 * 代理执行前会默认执行invoke方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		checkSecurity();
		Object ret = null;
		try {
			ret = method.invoke(this.targetObj, args);
		} catch (Exception e) {
			e.printStackTrace();
			throw new java.lang.RuntimeException(e);
		}
		return ret;
	}

	private static void checkSecurity() {
		System.out.println("------ SecurityHandler -- checkSecurity() ------");
	}
}
