package com.jibingkun.proxy.chapter03;
/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class ProxyTest {

	public static void main(String[] args) {
		
		CustomerProxy customer = new CustomerProxy();
		customer.buy(500D);
		System.out.println("客户需要付钱：" + customer.calLastPrice());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastPrice());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastPrice());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastPrice());

	}

}
