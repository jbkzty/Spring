package com.jibingkun.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Spring的事件驱动模型 -- 定义监听器
 * 
 * @author junjin4838
 * @version 1.0
 */

@Component
public class LisiListener implements ApplicationListener<ContentEvent> {

	public void onApplicationEvent(ContentEvent event) {
		System.out.println("用户junjin4838收到的新内容： " + event.getSource());
	}

}
