package com.jibingkun.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 消费者
 * @author junjin4838
 * @date 2016年9月8日
 * @version 1.0
 */
public class Consumer implements Runnable {

	private BlockingQueue queue;

	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println("启动消费者线程！");
		Random r = new Random();
		boolean isRunning = true;
		try {
			while (isRunning) {
				System.out.println("正从队列获取数据...");
				String data = (String) queue.poll(2, TimeUnit.SECONDS);
				if(null != data){
					System.out.println("拿到数据：" + data);
					System.out.println("正在消费数据：" + data);
					Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				}else{
					isRunning = false;
				}
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}finally{
			System.out.println("退出消费者线程！");
		}
	}

}
