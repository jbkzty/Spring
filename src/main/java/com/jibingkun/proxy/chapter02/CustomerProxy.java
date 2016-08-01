package com.jibingkun.proxy.chapter02;

import com.jibingkun.proxy.common.CalPrice;
import com.jibingkun.proxy.common.Common;

/**
 * 客户类 -- 一个抽象策略的实现
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class CustomerProxy {
	
	//客户在本店消费的总金额
	private Double totalAmount = 0D;
	
	//客户单词消费的金额
	private Double amount = 0D;
	
	//代理的策略，默认的是普通会员的策略
	private CalPrice calPrice = new Common();
	
	//客户购买商品，就会增加它的总额
	public void buy(Double price){
		this.amount = price;
		totalAmount += price;
		
		/*变化点：我们将策略的定制转移給策略工厂，将这部分责任分离出去*/
		/*这种工厂类，也有缺点，就是设计到了过多的if -else 若需求修改，还是要不断的去维护工程类  
		 *可以使用注解来解决这样的问题*/
		CustomerProxyFactory.createCalPrice(this);
		
	}
	
	//计算客户最终要付的钱
	public Double calLastPrice(){
		return calPrice.calPrice(amount);
	}
	
	public Double getTotalAmount(){
		return totalAmount;
	}
	
	public Double getAmount(){
		return amount;
	}

}
