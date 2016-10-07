package com.jibingkun.jdkAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @author junjin4838
 * @date 2016年9月21日
 * @version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {

	/**
	 * 目标对象
	 */
	private Object obj;

	public MyInvocationHandler(Object obj) {
		super();
		this.obj = obj;
	}

	/**
	 * 执行目标对象的方法
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("方法执行之前....");

		// 执行目标对象的方法
		Object result = method.invoke(obj, args);

		System.out.println("方法执行之后....");

		return result;
	}

	/**
	 * 获取目标对象的代理对象
	 * 
	 * @return 代理对象
	 */
	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread()
				.getContextClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	public static void main(String[] args) {
		//实例化目标对象
		UserService userService = new UserServiceImpl();
		
		//实例化InvocationHandler
		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
		
		//根据目标对象生成代理对象
		UserService proxy = (UserService)invocationHandler.getProxy();
		
		//调用代理对象的方法
		proxy.add();
	}
}
