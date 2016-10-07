package com.jibingkun.springEvent;

import org.springframework.context.ApplicationEvent;

/**
 * Spring的事件驱动模型 -- 事件类
 * Spring -- ApplicationEvent (所有的事件都要继承ApplicationEvent这个类，通过source获得事件源)
 *             -- ApplicationContextEvent
 *                     -- ContextStartedEvent    (ApplicationContext启动之后触发的事件)
 *                     -- ContextRefreshedEvent  (ApplicationContext初始化或者刷新之后触发的事件)
 *                     -- ContextStoppedEvent    (ApplicationContext停止之后触发的事件)
 *                     -- ContextClosedEvent     (ApplicationContext关闭之后触发的事件)
 * @author junjin4838
 * @version 1.0
 */
public class ContentEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = -2038706508073914783L;

	public ContentEvent(Object source) {
		super(source);
	}

}
