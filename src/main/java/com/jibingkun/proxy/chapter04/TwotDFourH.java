package com.jibingkun.proxy.chapter04;
/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */

@OnceValidRegion(@ValidRegion(min=2000,order=40))
public class TwotDFourH implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice - 400;
	}

}
