package com.leetcode;

import com.leetcode.LinkedListOddEven.ListNode;

public class PartitionList {
	public static void main(String[] args) {
		PartitionList p = new PartitionList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		p.partition(head, 3);
	}

	public ListNode partition(ListNode head, int x) {
		ListNode dummy = head;
		ListNode ans = head;
		ListNode prev = new ListNode(-1);
		ListNode after = new ListNode(-1);
		ListNode t1 = prev;
		ListNode t2 = after;
		boolean flag = false;
		while (dummy != null) {

			if (dummy.val < x) {
				prev.next = dummy;
				prev = prev.next;
			} else {
				after.next = dummy;
				after = after.next;
			}
			dummy = dummy.next;

		}
		prev.next =null;
		after.next=null;
		prev.next=t2.next;
		ListNode v1 = t1.next;

		return v1;
	}
}
