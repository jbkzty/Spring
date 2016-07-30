package com.jibingkun.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jibingkun.service.UserService;

/**
 * @author junjin4838
 * @date 2016年7月29日
 * @version 1.0
 */
public class Test {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		UserService us = (UserService) ac.getBean("userServiceImpl");

		us.getUser();
		us.update();
	}

}
