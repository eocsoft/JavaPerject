package net.example;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
//		System.out.println("begin");
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true){
//					System.out.println(String.valueOf(new Date().getTime()).substring(0, 10));
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//		System.out.println("end");
		
		ArrayList<Double> stack = new ArrayList<>();
		int max = 20;
		Thread t1 = new Thread(new Producer(max, stack));
		Thread t2 = new Thread(new Consumer(stack));
		
		t1.start();
		t2.start();
		
	}

	public Test() {
		super();
	}
}
