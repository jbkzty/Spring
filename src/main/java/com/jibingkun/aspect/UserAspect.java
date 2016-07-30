package com.jibingkun.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author junjin4838
 * @date 2016年7月29日
 * @version 1.0
 */
@Component
@Aspect
public class UserAspect {
	
	@Before(value = "execution(public * com.*.service..*.insert*(..))")
	public void beforeSave() {
		System.out.println("before save.");
	}
	
	@After(value = "execution(public * com.*.service..*.inset*(..))")
	public void afterSave() {
		System.out.println("after save.");
	}
	
	@Before(value = "execution(public * com.*.service..*.get*(..))")
	public void beforeQuery() {
		System.out.println("before query.");
	}
	
	@After(value = "execution(public * com.*.service..*.get*(..))")
	public void afterQuery() {
		System.out.println("after query.");
	}
	
	@Around("execution(public * com.*.service..*.update*(..))")
	public void aroundQuery(ProceedingJoinPoint pjp) {
		System.out.println("Around update.  1");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Around update.  2");
	}

}
