package com.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructIternary {
	public static void main(String[] args) {
		ReconstructIternary r=new ReconstructIternary();
		List<List<String>> ticket=new ArrayList<>();
		ticket.add(Arrays.asList("JFK","KUL"));
		ticket.add(Arrays.asList("JFK","NRT"));
		ticket.add(Arrays.asList("NRT","JFK"));

		r.findItinerary(ticket);
	}

	Map<String, PriorityQueue<String>> adj;

	public List<String> findItinerary(List<List<String>> tickets) {
		int n = tickets.size();
		adj = new HashMap<>();

		for (List<String> temp : tickets) {
            PriorityQueue<String> t =adj.get(temp.get(0));
			// System.out.println(t);
			if (t == null) {

				PriorityQueue<String> tp = new PriorityQueue<>();
				tp.add(temp.get(1));
				adj.put(temp.get(0), tp);

			} else {

				System.out.println(t);

				t.add(temp.get(1));
				adj.put(temp.get(0), t);
			}

		}
		System.out.println(adj);
		List<String> result = new ArrayList<>();

		finder("JFK", result);
		return result;

	}

	public void finder(String key, List<String> result) {
		PriorityQueue<String> pq = adj.get(key);
		while (pq != null && !pq.isEmpty()) {

			finder(pq.poll(), result);

		}
		result.add(0,key);


	}
}
