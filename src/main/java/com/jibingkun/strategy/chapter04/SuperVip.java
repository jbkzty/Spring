package com.jibingkun.strategy.chapter04;
/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
@TotalVaildRegion(@ValidRegion(min=2000,max=3000,order=99))
public class SuperVip implements CalPrice {

	public double calPrice(double originalPrice) {
		 return originalPrice * 0.7;
	}

}
