package com.jibingkun.strategy.chapter03;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


/**
 * 工厂类改造好之后，就要就便于后面增加策略了，不需要改动以前的代码模块
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class CalPriceFactory {
	
	//这是一个常量，表示我们要扫描的策略包
	private static final String  PROXY_PACKAGE = "com.jibingkun.proxy.chapter03";
	
	//类加载器
	private ClassLoader classLoader = getClass().getClassLoader();
	
	//策略列表
	private List<Class<? extends CalPrice>> proxyList;
	
	//根据客户的总金额产生相应的策略
	public CalPrice createCalPrice(CustomerProxy customer){
		for(Class<? extends CalPrice> clazz : proxyList){
			//获取该策略的注解
			TotalValidRegion validRegion = handleAnnotation(clazz);
			//判断金额是否在注解的区间
			if(customer.getTotalAmount() > validRegion.min() && customer.getTotalAmount() < validRegion.max()){
				try {
					return clazz.newInstance();
				} catch (Exception e) {
					throw new RuntimeException("策略获得失败");
				} 
			}
		}
		 throw new RuntimeException("策略获得失败");
	}
	
	/**
	 * 处理注解，存入一个策略类，返回他的注解
	 * @param clazz
	 * @return
	 */
	private TotalValidRegion handleAnnotation(Class<? extends CalPrice> clazz){
		Annotation[] annotations = clazz.getAnnotations();
		if(annotations == null || annotations.length == 0){
			return null;
		}
		for(int i=0;i<annotations.length;i++){
			if(annotations[i] instanceof TotalValidRegion){
				return (TotalValidRegion)annotations[i];
			}
		}
		return null;
	}
	
	/**
	 * 初始化
	 * 
	 */
	private CalPriceFactory(){
		init();
	}
	
	/**
	 * 在工厂初始化的时候要初始化策略列表
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void init(){
		
		//实现接口的列表
		proxyList = new ArrayList<Class<? extends CalPrice>>();
		
		//获取包下面所有的class文件
		File[] resources = getResources();
		
		System.out.println("获取到的文件数量：" + resources.length);
		
		Class<CalPrice> calPriceProxyClazz = null;
		
		try {
			//使用相同的加载器加载策略接口
			calPriceProxyClazz = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("未找到策略接口");
		}
		
		for(int i =0;i<resources.length;i++){
			try {
				//载入包下面的类
				Class<?> clazz = classLoader.loadClass(PROXY_PACKAGE + "." + resources[i].getName().replace(".class", ""));
				//判断是否是CalPrice的实现类并且不是CalPrice它本身，满足的话加入到策略列表
				if(CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceProxyClazz){
					proxyList.add((Class<? extends CalPrice>) clazz);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 获取扫描的包下面所有的class文件
	 * @return
	 */
	private File[] getResources(){
		try {
			File file = new File(classLoader.getResource(PROXY_PACKAGE.replace(".", "/")).toURI());
			return file.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					//只扫描class文件
					if(pathname.getName().endsWith(".class")){
						return true;
					}
					return false;
				}
			});
		} catch (URISyntaxException e) {
			throw new RuntimeException("未找到资源");
		}
	}
	
	public static CalPriceFactory getInstance(){
		return CalPriceFactoryInstance.instance;
	}
	
    private static class CalPriceFactoryInstance{
         private static CalPriceFactory instance = new CalPriceFactory();
    }
	

}
