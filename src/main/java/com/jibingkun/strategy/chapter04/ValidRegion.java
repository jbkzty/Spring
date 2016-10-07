package com.jibingkun.strategy.chapter04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个嵌套注解
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRegion {
	
	int max() default Integer.MAX_VALUE;
	
	int min() default Integer.MIN_VALUE;
	
	/*组合策略的顺序，比如是先执行打折再减扣现金;还是先减扣现金在打折*/
	int order() default 0;

}
