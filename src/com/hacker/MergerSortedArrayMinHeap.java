package com.hacker;

import com.leetcode.MergeKSortedList;

public class MergerSortedArrayMinHeap {
	static ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		MergerSortedArrayMinHeap mt = new MergerSortedArrayMinHeap();
		ListNode n = new ListNode(1);
		n.next = new ListNode(4);
		n.next.next = new ListNode(5);
		ListNode m = new ListNode(1);
		m.next = new ListNode(3);
		m.next.next = new ListNode(4);
		ListNode p = new ListNode(2);
		p.next = new ListNode(6);
		ListNode[] listNodes = { n, m, p };
		mt.mergeKLists(listNodes);
	}
	public ListNode mergeKLists(ListNode[] lists) {
		for (int i = 0; i < lists.length; i++) {
			
		}
		return null;
		
	}


}
