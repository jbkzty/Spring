package com.jibingkun.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 切面Demo
 * @author junjin4838
 * @version 1.0
 */
public class AspectTest {
	
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		UserService us = (UserService) ac.getBean("userServiceImpl");

		us.getUser();
		us.update();
	}

}
