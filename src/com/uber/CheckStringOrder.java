package com.uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class CheckStringOrder {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CheckStringOrder c = new CheckStringOrder();
		String rule = "abcdef";
		String st[] = { "axbbcdd", "ewsxfmnf", "ffgfhf", "fffffff" };
		CountDownLatch cds = new CountDownLatch(st.length);
		Semaphore sem = new Semaphore(20);
		Map<Character, Integer> mp = new HashMap<>();
		for (int i = 0; i < rule.length(); i++) {
			mp.put(rule.charAt(i), i);
		}
		
		ExecutorService exe = Executors.newFixedThreadPool(4);
		List<StringBuilder> collect = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			Future<StringBuilder> val1 = exe.submit(new Order(st[i], mp, sem, cds));
			collect.add(val1.get());
			Thread.sleep(100);
		}
		cds.await();
		StringBuilder result = new StringBuilder();
		int prev = 0;
		char prevChar = '0';
		for (StringBuilder sb : collect) {
			for (char cd : sb.toString().toCharArray()) {
				if (prevChar == cd) {
					continue;
				}
				if (prev < rule.length() && prevChar != cd && rule.charAt(prev) == cd) {
					prevChar = cd;
					prev++;
				} else {
					System.out.println("Not in Order");
					return;
				}
			}
		}

		System.out.println("In Order");
		exe.shutdown();
	}
}

class Order implements Callable<StringBuilder> {
	String st;
	Map<Character, Integer> rule;
	Semaphore sem;
	CountDownLatch cd;

	public Order(String st, Map<Character, Integer> rule, Semaphore sem, CountDownLatch cd) {
		this.st = st;
		this.rule = rule;
		this.sem = sem;
		this.cd = cd;
	}

	@Override
	public StringBuilder call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		sem.acquire();
		StringBuilder sb = calculate(st, rule);
		if (sb.length() == 0) {
			System.out.println("Not in order");
		}

		sem.release();
		cd.countDown();
		//Thread.sleep(1000);
		return sb;

	}

	private StringBuilder calculate(String str, Map<Character, Integer> rule) {
		StringBuilder sb = new StringBuilder();
		int max = 0;
		char prev = '0';
		for (int i = 0; i < str.length(); i++) {
			if (!rule.containsKey(str.charAt(i))) {
				continue;
			}
			if (rule.get(str.charAt(i)) >= max) {
				if (prev == '0' || prev != str.charAt(i)) {
					sb.append(st.charAt(i));
					prev = str.charAt(i);
				}

				max = rule.get(str.charAt(i));
			} else {
				return new StringBuilder();
			}
		}
		return sb;
	}

}