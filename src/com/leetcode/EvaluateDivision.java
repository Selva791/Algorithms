package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	public static void main(String[] args) {
		EvaluateDivision e=new EvaluateDivision();
		List<List<String>> equations=new ArrayList<>();
		equations.add(Arrays.asList("a","b"));
		equations.add(Arrays.asList("b","c"));
		
		double []values= {2.0,3.0};
		 List<List<String>> queries=new ArrayList<>();
		 queries.add(Arrays.asList("a","c"));
		 queries.add(Arrays.asList("b","a")); 
		 queries.add(Arrays.asList("a","e"));
		 queries.add(Arrays.asList("a","a"));
		 queries.add(Arrays.asList("x","x"));
		e.calcEquation(equations, values, queries);
	}
	 public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	        
	        /* Build graph. */
	        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
	        double[] result = new double[queries.size()];
	        
	        for (int i = 0; i < queries.size(); i++) {
	            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
	        }  
	        
	        return result;
	    }
	    
	    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
	        
	        /* Rejection case. */
	        if (!graph.containsKey(start)) 
	            return -1.0;
	        
	        /* Accepting case. */
	        if (graph.get(start).containsKey(end))
	            return graph.get(start).get(end);
	        
	        visited.add(start);
	        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
	            if (!visited.contains(neighbour.getKey())) {
	                double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
	                if (productWeight != -1.0)
	                    return neighbour.getValue() * productWeight;
	            }
	        }
	        
	        return -1.0;
	    }
	    
	    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
	        Map<String, Map<String, Double>> graph = new HashMap<>();
	        String u, v;
	        
	        for (int i = 0; i < equations.size(); i++) {
	            u = equations.get(i).get(0);
	            v = equations.get(i).get(1);
	            graph.putIfAbsent(u, new HashMap<>());
	            graph.get(u).put(v, values[i]);
	            graph.putIfAbsent(v, new HashMap<>());
	            graph.get(v).put(u, 1 / values[i]);
	        }
	        
	        return graph;
	    }
}
