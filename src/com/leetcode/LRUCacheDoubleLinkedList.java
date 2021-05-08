package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDoubleLinkedList {
	public static void main(String[] args) {
		LRUCacheDoubleLinkedList l = new LRUCacheDoubleLinkedList(2);
		l.put(2, 1);
		l.put(2, 2);
		l.get(2);
		l.put(1, 1);
		l.put(4, 1);
		l.get(2);
	}

	  Map<Integer, Node> cache;
		Node head, tail;
		int cap,c;

		class Node {
			Node pre, next;
			int val, key;

			Node(int k, int v) {
				val = v;
				key = k;
				pre = next = null;
			}
		}

		public LRUCacheDoubleLinkedList(int capacity) {
			cache = new HashMap<>();
			cap = capacity;
	        c=0;
	        head=new Node(0,0);
	        tail=new Node(0,0);
	        head.pre=tail;
	        tail.next=head;
	        
		}

		public int get(int key) {
			if(!cache.containsKey(key))return -1;
			
	        Node val=cache.get(key);
	        cache.remove(key);
	        remove(val);
	        add(val);
	        cache.put(key,val);
	        return val.val;
		}
	    public void put(int key, int value) {
	            Node s=cache.get(key);
			    if(s==null){
	                Node v=new Node(key,value);
	                cache.put(key,v);
	                add(v);
	                c++;
	                
	            }else{
	                
	                s.val=value;
	                remove(s);
	                add(s);
	            }
	        if(c>cap){
	            Node del=tail.next;
	            cache.remove(del.key);
	            remove(del);
	            c--;
	        }
	           
		}

		public void remove(Node cur) {
			    Node before=cur.pre;
	            Node after=cur.next;
	            cur.pre=cur.next=null;
	            before.next=after;
	            after.pre=before;
		}

		public void add(Node cur) {
			    Node before=head.pre;
	            before.next=cur;
	            cur.pre=before;
	            head.pre=cur;
	            cur.next=head;
	            
		}

}
