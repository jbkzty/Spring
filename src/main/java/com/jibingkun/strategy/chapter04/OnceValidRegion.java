package com.jibingkun.strategy.chapter04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */

@Target(ElementType.TYPE)//表示只能给类添加该注解
@Retention(RetentionPolicy.RUNTIME)//这个必须要将注解保留在运行时
public @interface OnceValidRegion {
	
	//我们引用有效区间注解
    ValidRegion value() default @ValidRegion;	

}
