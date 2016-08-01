package com.jibingkun.proxy.chapter03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这是我们的有效区间注解，可以给策略添加有效区间的设置
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */

@Target(ElementType.TYPE) //表示只能给类添加这个注释
@Retention(RetentionPolicy.RUNTIME) //这个必须要将注解保留在运行时
public @interface TotalValidRegion {
	
	int max() default Integer.MAX_VALUE;
	
	int min() default Integer.MIN_VALUE;
	

}
