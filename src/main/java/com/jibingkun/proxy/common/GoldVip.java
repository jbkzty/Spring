package com.jibingkun.proxy.common;
/**
 * 折扣打半折
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class GoldVip implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice * 0.5;
	}

}
