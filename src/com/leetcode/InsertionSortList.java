package com.leetcode;

import com.leetcode.LinkedListOddEven.ListNode;

public class InsertionSortList {
	public static void main(String[] args) {
		InsertionSortList s=new InsertionSortList();
		ListNode head=new ListNode(-1);
		head.next=new ListNode(5);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(0);

		s.insertionSortList(head);
	}
	
	public ListNode insertionSortList(ListNode head) {
        ListNode cur=head;
        ListNode dummy=new ListNode(0);
        ListNode value=head.next;
        ListNode prev=dummy;
        while(cur!=null){
           value=cur.next;
        	while(prev.next!=null&&prev.next.val<cur.val) {
        		prev=prev.next;
        	}
        	
        	cur.next=prev.next;
        	prev.next=cur;
        	cur=value;
        	prev=dummy;
        	
        }
        return dummy.next;
    }

}



