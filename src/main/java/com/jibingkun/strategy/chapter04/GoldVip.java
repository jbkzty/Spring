package com.jibingkun.strategy.chapter04;
/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
@TotalVaildRegion(@ValidRegion(min=3000,order=99))
public class GoldVip implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice * 0.5;
	}

}
