package com.jibingkun.proxy.chapter03;


/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */

@TotalValidRegion(min=1000,max=2000)
public class Vip implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice * 0.8;
	}

}
