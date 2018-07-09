package com.spider.passport.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	private Lock lock = new ReentrantLock();
	
	public void print(Thread thread) {
		try {
			lock.lock();
			System.out.println(thread.getName() + " start lock ...................");
			Thread.sleep(3000L);
			System.out.println(thread.getName() + " end lock ...................");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final ReentrantLockTest rtl = new ReentrantLockTest();
		new Thread(new Runnable(){
			@Override
			public void run() {
				rtl.print(Thread.currentThread());
			}
			
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				rtl.print(Thread.currentThread());
			}
			
		}).start();
	}

}
