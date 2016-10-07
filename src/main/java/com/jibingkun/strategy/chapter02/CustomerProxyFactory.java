package com.jibingkun.strategy.chapter02;

import com.jibingkun.strategy.common.CalPrice;
import com.jibingkun.strategy.common.Common;
import com.jibingkun.strategy.common.GoldVip;
import com.jibingkun.strategy.common.SupVip;
import com.jibingkun.strategy.common.Vip;

/**
 * 将代理类改成工程类实现
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.1
 */
public class CustomerProxyFactory {
	
	private CustomerProxyFactory(){};
	
	public static CalPrice createCalPrice(CustomerProxy proxy){
		if(proxy.getTotalAmount() > 3000){
			return new GoldVip();
		}else if(proxy.getTotalAmount() > 2000){
			return new SupVip();
		}else if (proxy.getTotalAmount() > 1000) {
            return new Vip();
        }else {
            return new Common();
        }
	}

}
