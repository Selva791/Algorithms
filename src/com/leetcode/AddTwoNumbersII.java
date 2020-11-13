package com.leetcode;

import com.leetcode.LinkedListOddEven.ListNode;

public class AddTwoNumbersII {
	public static void main(String[] args) {
		AddTwoNumbersII a=new AddTwoNumbersII();
		ListNode l1=new ListNode(7);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		l1.next.next.next=new ListNode(3);
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		a.addTwoNumbers(l1, l2);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp = l1;
		ListNode cur = null;
		ListNode value = null;
		int m1 = 0, m2 = 0;
		while (temp != null) {
			cur = temp;
			temp = temp.next;
			cur.next = value;
			value = cur;
			m1++;
		}

		ListNode temp1 = l2;
		ListNode cur1 = null;
		ListNode value1 = null;
		while (temp1 != null) {
			cur1 = temp1;
			temp1 = temp1.next;
			cur1.next = value1;
			value1 = cur1;
			m2++;
		}
		int r = 0;
		ListNode r1=value;
		ListNode r2=value1;
		while (value != null || value1 != null) {
			if (value != null && value1 != null) {
				int sum = value.val + value1.val;
				sum += r;

				r = sum/10;
				sum = sum % 10;
				if (m1 > m2) {
					value.val = sum;
				} else {
					value1.val = sum;
				}
				value = value.next;
				value1 = value1.next;
			} else if (value == null) {
				int sum = value1.val;
				sum += r;
				r = sum/10;
				sum = sum % 10;

				value1.val = sum;
				value1 = value1.next;
			} else if (value1 == null) {
				int sum = value.val;
				sum += r;
				r = sum/10;
				sum = sum % 10;
				value.val = sum;
				value = value.next;
			}
		}
		if (m1 > m2) {
			ListNode t1 = r1;
			ListNode c1 = null;
			ListNode v1 = null;
			while (t1 != null) {
				c1 = t1;
				t1 = t1.next;
				c1.next = v1;
				v1 = c1;
				m2++;
			}
			return v1;
		}
			
		else {
			ListNode t1 = r2;
			ListNode c1 = null;
			ListNode v1 = null;
			while (t1 != null) {
				c1 = t1;
				t1 = t1.next;
				c1.next = v1;
				v1 = c1;
				m2++;
			}
			return v1;
		}
			

	}
}
