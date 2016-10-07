package com.jibingkun.strategy.common;
/**
 * 普通顾客
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class Common implements CalPrice {

	/**
	 * 普通会员，原价售出
	 * 
	 */
	public double calPrice(double originalPrice) {
		return originalPrice;
	}

}
