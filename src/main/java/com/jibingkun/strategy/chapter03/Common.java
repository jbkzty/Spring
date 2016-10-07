package com.jibingkun.strategy.chapter03;

/**
 * 
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
//设置普通的在0-1000生效

@TotalValidRegion(max=1000)
public class Common implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice;
	}

}
