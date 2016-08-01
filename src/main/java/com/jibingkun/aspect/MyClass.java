package com.jibingkun.aspect;

public class MyClass {
	
	public void myMethod(MyInterface myInterface){
		System.out.println("方法里面的代码开始");
		//有个需求现在这边插入业务代码，而且代码可能会有时刻变动
		myInterface.doSomeThing();
		System.out.println("方法里面的代码结束");
	}

}
