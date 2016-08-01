package com.jibingkun.proxy.chapter02;
/**
 * 客户端实现
 * 运行以后会发现:
 *     第一次是原价
 *     第二次是八折
 *     第三次是七折，
 *     第四次则是半价
 * 我们这样设计的好处是，客户不再依赖于具体的收费策略，依赖于抽象永远是正确的。
 * 不过上述的客户类实在有点难看，尤其是buy方法，我们可以使用简单工厂来稍微改进一下它。我们建立如下策略工厂。
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
