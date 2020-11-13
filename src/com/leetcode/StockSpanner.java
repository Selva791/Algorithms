package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class StockSpanner {
    Stack<int[]> s;

    public StockSpanner() {
        s = new Stack<>();
       // arr==s.toArray();
        
    }
    public static void main(String[] args) {
    	//["StockSpanner","next","next","next","next","next"]
    	//[[],[29],[91],[62],[76],[51]]
    	StockSpanner obj = new StockSpanner();
    	 int param_1 = obj.next(29);
    	 int param_2 = obj.next(71);
    	 int param_3 = obj.next(62);
    	 int param_4 = obj.next(76);
    	 int param_5 = obj.next(51);
    	 //int param_6 = obj.next(75);
    	//int param_7= obj.next(85);
    	// int param_1 = obj.next(100);

	}
    
    public int next(int price) {
        int span = 1;

    	 while (!s.isEmpty() && price >= s.peek()[0]) { // If the current price is greater than stack peek.
             span += s.peek()[1];
             s.pop();
         }
         s.push(new int[]{price, span});
         return span;
       
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */