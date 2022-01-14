package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOoneDataStructure {

	public static void main(String[] args) {
		AllOoneDataStructure a = new AllOoneDataStructure();
		a.inc("hello");
		a.inc("goodbye");
		a.inc("hello");
		a.inc("hello");
		System.out.println(a.getMaxKey());
		a.inc("leet");
		a.inc("code");
		a.inc("leet");
		a.dec("hello");
		a.inc("leet");
		a.inc("code");
		a.inc("code");
	System.out.println(a.getMaxKey());

	}

	public AllOoneDataStructure() {
		count = new HashMap<>();
		check = new HashMap<>();
		head = new Bucket(Integer.MIN_VALUE);
		tail = new Bucket(Integer.MAX_VALUE);
		head.next=tail;
		tail.pre=head;
	}

	Map<String,Integer> count;
	Map<Integer, Bucket> check;
	Bucket head;
	Bucket tail;

	class Bucket {
		Set<String> key;
		Bucket pre;
		Bucket next;
		int count;

		Bucket(int n) {
			count = n;
			key = new HashSet<>();
		}

	}

	public void inc(String key) {
		if (count.containsKey(key)) {
			changeKey(key, 1);
		} else {
			count.put(key,1);
			if(head.next.count!=1)
			addValue(new Bucket(1), head);
			
			
			
			head.next.key.add(key);
			check.put(1, head.next);

		}

	}

	private void addValue(Bucket bucket, Bucket preNode) {
		bucket.pre = preNode;
		bucket.next = preNode.next;
		preNode.next.pre = bucket;
		preNode.next = bucket;

	}

	private void changeKey(String key, int off) {
		int cur = count.get(key);
		count.put(key, cur+off);
		Bucket curNode=check.get(cur);
		Bucket newNode = null;
		
		if (check.containsKey(cur+off)) {
			newNode=check.get(cur+off);
		} else {
			
			newNode=new Bucket(cur+ off);
			check.put(cur+off, newNode);
			
			addValue(newNode, off==1?curNode:curNode.pre);

		}
		newNode.key.add(key);
		removeNode(curNode,key);
	}

	public void removeNode(Bucket cur, String key) {
		cur.key.remove(key);
		if(cur.key.size()==0) {
			removeNodeValue(cur);
			count.remove(cur.count);
		}

	}

	private void removeNodeValue(Bucket curNode) {
		curNode.pre.next=curNode.next;
		curNode.next.pre=curNode.pre;
		curNode.next=null;
		curNode.pre=null;
		
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the data
	 * structure.
	 */
	public void dec(String key) {
		if(count.containsKey(key)) {
			int n=count.get(key);
			if(n==1) {
				count.remove(key);
				removeNode(check.get(n),key);
			}else {
				changeKey(key, -1);
			}
			
		}

	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return tail.pre==head?"":(String)tail.pre.key.iterator().next();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return head.next==tail?"":head.next.key.iterator().next();
		
	}
}
