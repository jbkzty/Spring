package com.jibingkun.springEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 定义有序监听器 -- UserTwo
 * @author junjin4838
 * @version 1.0
 */

@Component
public class UserTwoListener implements SmartApplicationListener {

	public void onApplicationEvent(ApplicationEvent event) {
       System.out.println("用户UserTwo收到新的内容： " + event.getSource());
	}

	/**
	 * 按顺序排序，数字越小，等级越高
	 */
	public int getOrder() {
		return 2;
	}

	/**
	 * 支持的事件类型
	 */
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == ContentEvent.class;
	}

	/**
	 * 支持的目标类型
	 */
	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == String.class;
	}

}
