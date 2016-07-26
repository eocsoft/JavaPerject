package net.example;

import java.util.List;

public class Consumer implements Runnable {
	private List<Double> stack;

	public Consumer(List<Double> stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void run() {
		while(true){
			synchronized (stack) {
				while (stack.isEmpty()) {
					try {
						stack.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				consume();
				stack.notify();
			}
		}
	}

	public void consume() {
		double goods = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		System.out.println("consume:" + goods + "size:" + stack.size());
	}

}
