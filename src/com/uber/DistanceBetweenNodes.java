package com.uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceBetweenNodes {
	public static void main(String[] args) {
		DistanceBetweenNodes dist = new DistanceBetweenNodes();
		String[][] cost = { { "USD", "EUR" }, { "EUR", "YEN" }, { "METER", "YARD" } };
		double value[] = { 0.84, 130.3, 1.09 };
		dist.graphDistance(cost, value);
	}

	class Data {
		double value;
		String country;

		Data(double value, String country) {
			this.value = value;
			this.country = country;
		}
	}

	private void graphDistance(String[][] cost, double[] value) {
		// TODO Auto-generated method stub
		Map<String, List<Data>> graph = new HashMap<>();

		for (int i = 0; i < cost.length; i++) {
			String str[] = cost[i];
			if (!graph.containsKey(str[0])) {
				graph.put(str[0], new ArrayList<>());
			}
			List<Data> list = graph.get(str[0]);
			list.add(new Data(value[i], str[1]));
		}
		System.out.println(traverse(graph, "USD", "YEN"));
	}

	private double traverse(Map<String, List<Data>> graph, String st1, String st2) {
		double cost = 0.0;
		List<Data> list = graph.get(st1);
		for (Data data : list) {
			if (data.country.equals(st2)) {
				cost = data.value;
				break;
			} else {
				cost = data.value * traverse(graph, data.country, st2);
			}
		}
		return cost;
	}

}
