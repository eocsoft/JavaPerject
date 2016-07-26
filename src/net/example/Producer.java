package net.example;

import java.util.List;

public class Producer implements Runnable {
	private int max;
	private List<Double> stack;

	public Producer(int max, List<Double> stack) {
		super();
		this.max = max;
		this.stack = stack;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (stack) {
				while (stack.size() == max) {
					try {
						stack.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				produce();
				stack.notify();
			}
		}
	}

	private void produce() {
		double goods = Math.random();

		stack.add(goods);
		System.out.println("produce:" + goods + " size:" + stack.size());
	}
}
