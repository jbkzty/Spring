package com.jibingkun.proxy.common;
/**
 * vip顾客，售价打8折
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class Vip implements CalPrice {

	/**
	 * vip 顾客 售价打8折
	 * 
	 */
	public double calPrice(double originalPrice) {
		return originalPrice * 0.8;
	}

}
