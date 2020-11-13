package com.hacker;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LRUCache {
	Deque<Integer> dq;
	HashSet<Integer> hash;
	int csize;
	public LRUCache(int size) {
		 dq=new LinkedList<Integer>();
		 hash=new HashSet<>();
		 csize=size;
	}
private void refer(int i) {
	if(!hash.contains(i)) {
		if(dq.size()==csize) {
			int temp=dq.removeLast();
			hash.remove(temp);
		}
		
	}else {
		int d=0;
		Iterator<Integer> lit=dq.iterator();
		while(lit.hasNext()) {
			if(lit.next()==i) {
				break;
			}
			d++;
		}
		dq.remove(d);
		
	}
		dq.push(i);
		hash.add(i);
	}
public static void main(String[] args) {
	LRUCache ca = new LRUCache(4); 
    ca.refer(1); 
    ca.refer(2); 
    ca.refer(3); 
    ca.refer(1); 
    ca.refer(4); 
    ca.refer(5); 
    ca.display();
}
private void display() {

	Iterator<Integer> lit=dq.iterator();
	while(lit.hasNext()) {
	System.out.println(lit.next());	
	}
}
}
