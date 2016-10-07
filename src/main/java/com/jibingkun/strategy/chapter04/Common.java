package com.jibingkun.strategy.chapter04;


/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */

@TotalVaildRegion(@ValidRegion(max=1000,order=99))
public class Common implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice;
	}

}
