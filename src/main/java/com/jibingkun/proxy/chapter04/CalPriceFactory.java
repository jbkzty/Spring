package com.jibingkun.proxy.chapter04;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;



/**
 * @author junjin4838
 * @date 2016年8月1日
 * @version 1.0
 */
public class CalPriceFactory {

	// 策略文件的路径
	private static final String PROXY_FILE = "com.jibingkun.proxy.chapter04";

	// 类加载器
	private ClassLoader classLoad = getClass().getClassLoader();

	// 策略列表
	private List<Class<? extends CalPrice>> proxyList;
	
	/**
	 * 根据条件生成特定的策略
	 * @return
	 */
	public CalPrice createCalPrice(CustomerProxy customerProxy){
		
		SortedMap<Integer, Class<? extends CalPrice>> clazzMap = new TreeMap<Integer, Class<? extends CalPrice>>();
		
		for(Class<? extends CalPrice> clazz : proxyList){
			//获取该策略的注解
			Annotation validRegion = handlerAnnotation(clazz);
			if(validRegion instanceof TotalVaildRegion){
				TotalVaildRegion totalValidRegion = (TotalVaildRegion) validRegion;
				//判断总金额是否在注解的区间
				if(customerProxy.getTotalAmount() > totalValidRegion.value().min() && customerProxy.getTotalAmount() < totalValidRegion.value().max()){
					//将采用的策略放入MAP
					clazzMap.put(totalValidRegion.value().order(), clazz);
				}
			}else if(validRegion instanceof OnceValidRegion){
				OnceValidRegion onceValidRegion = (OnceValidRegion) validRegion;
				//判断单次金额是否在注解的区间，注意这次判断的是客户当次消费的金额
				if (customerProxy.getAmount() > onceValidRegion.value().min() && customerProxy.getAmount() < onceValidRegion.value().max()) {
					//将采用的策略放入MAP
					clazzMap.put(onceValidRegion.value().order(), clazz);
                }
			}
		}
		
		try {
            //我们采用动态代理处理策略重叠的问题
            return CalPriceProxy.getProxy(clazzMap);
        } catch (Exception e) {
            throw new RuntimeException("策略获得失败");
        }
		
	}
	
	
	/**
	 * 对类注解进行处理
	 * @param clazz
	 * @return
	 */
	private Annotation handlerAnnotation(Class<? extends CalPrice> clazz){
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		if(annotations == null || annotations.length == 0 ){
			return null;
		}
		
		for(int i=0;i<annotations.length;i++){
			if(annotations[i] instanceof TotalVaildRegion || annotations[i] instanceof OnceValidRegion){
				return annotations[i];
			}
		}
		return null;
	}

	/**
	 * 默认构造器
	 * 
	 */
	public CalPriceFactory() {
		init();
	}

	/**
	 * 初始化 CalPriceFactory 工厂类
	 */
	@SuppressWarnings("unchecked")
	public void init() {
		
		proxyList = new ArrayList<Class<? extends CalPrice>>();
		
		//获取包下面的全部文件
		File[] files = getFile();
		System.out.println("获取到的文件数量：" + files.length);
		
		Class<CalPrice> calPriceProxyClazz = null;
		
		try {
			calPriceProxyClazz = (Class<CalPrice>)classLoad.loadClass(CalPrice.class.getName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for(int i=0;i<files.length;i++){
			try {
				Class<?> clazz = classLoad.loadClass(PROXY_FILE + "." + files[i].getName().replace(".class", "") );
				if(CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceProxyClazz){
					proxyList.add((Class<? extends CalPrice>) clazz);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 扫描指定包下面的全部文件
	 * @return
	 */
	private File[] getFile() {
		try {
			File file = new File(classLoad.getResource(
					PROXY_FILE.replace(".", "/")).toURI());
			return file.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					if (pathname.getName().endsWith(".class")) {
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
