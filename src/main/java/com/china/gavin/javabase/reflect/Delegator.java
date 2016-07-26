package com.china.gavin.javabase.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class Delegator implements InvocationHandler {

	// 原始對象
	protected Object orginObj = null;
	// 代理對象
	protected Object proxyObj = null;

	public Delegator() {

	}

	public Delegator(Object orgin) {
		this.createProxy(orgin);
	}

	protected Object createProxy(Object orgin) {
		// TODO Auto-generated method stub
		this.orginObj = orgin;
		/**
		 * orgin.getClass().getClassLoader() 為加載器
		 * orgin.getClass().getInterfaces() 為接口集
		 */
		this.orginObj = Proxy.newProxyInstance(orgin.getClass()
				.getClassLoader(), orgin.getClass().getInterfaces(), this);
		return orgin;
	}

	protected Object invokeSuper(Method method, Object[] objArray)
			throws Throwable {
		return method.invoke(this.orginObj, objArray);
	}

	/**
	 * --------------实现InvocationHandler接口，要求覆盖------------
	 * 面实现的方法是当委托的类调用toString()方法时，操作其他方法而不是该类默认的toString()，这个类的其他方法则不会。
	 */
	@Override
	public Object invoke(Object obj, Method method, Object[] objArray)
			throws Throwable {
		// TODO Auto-generated method stub
		// 缺省实现：委托给orginObj完成对应的操作
		if (method.getName().equals("toString")) {
			// 对其做额外处理
			return this.invokeSuper(method, objArray) + "$Proxy";
		} else {
			// 注意，调用原始对象的方法，而不是代理的（obj==orginObj）
			return this.invokeSuper(method, objArray);
		}
	}

}
