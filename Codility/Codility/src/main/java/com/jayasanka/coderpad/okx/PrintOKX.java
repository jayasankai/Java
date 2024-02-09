package com.jayasanka.coderpad.okx;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOKX {

	public static void main(String[] args) throws InterruptedException {

		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		Lock lock3 = new ReentrantLock();
		
		Condition c1 = lock1.newCondition();
		Condition c2 = lock2.newCondition();
		Condition c3 = lock3.newCondition();

		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					lock1.lock();
					System.out.print("O");
					try {
						// c1.await();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						// lock1.unlock();
					}
				}
			};
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					lock2.lock();
					System.out.print("K");
					try {
						//c2.await();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						// lock2.unlock();
					}
				}
			};
		};

		Thread t3 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						lock3.lock();
						System.out.println("X");
//						c3.await();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						lock1.unlock();
						lock2.unlock();
						lock3.unlock();
//						c1.signal();
//						c2.signal();
					}
				}
			};
		};

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();

	}

}
