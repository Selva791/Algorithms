package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDoubleLinkedList {
	public static void main(String[] args) {
		LRUCacheDoubleLinkedList l = new LRUCacheDoubleLinkedList(2);
		l.put(1, 0);
		l.put(2, 2);
		l.get(1);
		l.put(3, 3);
		l.get(2);
		l.put(4, 4);
		l.get(1);
		l.get(3);
		l.get(4);
	}

	Node head,tail;
	class Node{
		Node prev,next;
		int val;
		int key;
		Node(int val,int key){
			this.val=val;
			this.key=key;
			prev=next=null;
		}
	}
	Map<Integer,Node> mp;
	int capacity;

	public LRUCacheDoubleLinkedList(int capacity) {
		mp=new HashMap<>();
		this.capacity=capacity;
		head=new Node(-1,-1);
		tail=new Node(-1,-1);
		head.prev=tail;
		tail.next=head;
	}

	public int get(int key) {
		if(!mp.containsKey(key)){
			return -1;
		}
		Node node=mp.get(key);
		changeHead(node);
		return node.val;
	}
	public void changeHead(Node node){
		Node prev=node.prev;
		Node nxt=node.next;
		prev.next=nxt;
		nxt.prev=prev;
		addHead(node);
	}
	public void addHead(Node node){
		Node temp=head.prev;
		temp.next=node;
		node.prev=temp;
		node.next=head;
		head.prev=node;

	}
	public void put(int key, int value) {
		Node newNode=null;
		if(!mp.containsKey(key)){
			if(capacity==mp.size()){
				Node r=tail.next;
				tail.next=r.next;
				r.next.prev=tail;
				mp.remove(r.key);
			}
			newNode=new Node(value,key);
			mp.put(key,newNode);
			addHead(newNode);
		}else{
			newNode=mp.get(key);
			changeHead(newNode);
		}

	}

}
