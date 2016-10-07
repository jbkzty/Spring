package com.jibingkun.strategy.common;
/**
 * Super vip 用户打7折
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class SupVip implements CalPrice {

	/**
	 * Super vip 用户打7折
	 */
	public double calPrice(double originalPrice) {
		return originalPrice * 0.7;
	}

}
