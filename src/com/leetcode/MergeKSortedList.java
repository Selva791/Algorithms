package com.leetcode;

import java.util.PriorityQueue;

import com.leetcode.LinkedListOddEven.ListNode;

public class MergeKSortedList {

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
		MergeKSortedList mt = new MergeKSortedList();
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
	        if(lists.length==0) return null;
	        
	        if(lists.length==1)return lists[0];

	        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
	        
	        for(ListNode value:lists){
	            if(value!=null)
	            pq.add(value);
	            
	        }
	          ListNode temp=null;
	        while(!pq.isEmpty()){
	          ListNode t=pq.poll();

	             if(temp==null&&t!=null){
	                 temp=t;
	                 
	                 if(t.next!=null){
	                    pq.add(t.next);

	                 }
	                 break;
	             }
	        }
	        ListNode result=temp;
	        
	        while(!pq.isEmpty()){
	          ListNode t=pq.poll();
	            if(t!=null){
	                 temp.next=t;
	            if(t.next!=null)
	                pq.add(t.next);
	                 
	               temp=temp.next;
	            
	             }
	            
	            

	        }
	        
	        
	        return result;
	    }
	/*public ListNode mergeKLists(ListNode[] lists) {
		ListNode temp = null;
		int n = lists.length;
		for (int i = 0; i < lists.length; i++) {
			if (temp == null) {
				temp = merge(lists[i], lists[i + 1]);

			} else if (i + 1 < n) {
				temp = merge(temp, lists[i + 1]);
			}
		}
		return temp;
	}

	public ListNode merge(ListNode node, ListNode num) {
		if (node == null) {
			return num;
		}
		if (num == null) {
			return node;

		}
		ListNode value;
		if (num.val > node.val) {
			value = node;
			value.next = merge(node.next, num);
		} else {
			value = num;
			value.next = merge(node, num.next);

		}
		return value;
	}
*/
}
