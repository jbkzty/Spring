package com.jibingkun.springEvent;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 * 
 * 用户UserOne会在用户UserTwo之前收到新的内容： 测试开始...
 * 用户UserTwo收到新的内容： 测试开始...
 * 用户junjin4838收到的新内容： 测试开始...
 * 
 * @author junjin4838
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext-event.xml"}) 
public class Test {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@org.junit.Test
	public void testPublishEvent(){
		applicationContext.publishEvent(new ContentEvent("测试开始...")); 
	}

}
