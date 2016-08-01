package com.jibingkun.aspect;

public class Test {
	
	public static void main(String[] args) {
		MyClass myclass = new MyClass();
		
		myclass.myMethod(new MyInteface1());
		System.out.println("--------------------");
		myclass.myMethod(new MyInteface2());
		
	}

}
