package com.leetcode;

import com.leetcode.LinkedListOddEven.ListNode;

public class ReorderLinkedList {
	public static void main(String[] args) {
		ListNode n=new ListNode(1);
		n.next=new ListNode(2);
		n.next.next=new ListNode(3);
		n.next.next.next=new ListNode(4);
		n.next.next.next.next=new ListNode(5);
	//	n.next.next.next.next.next=new ListNode(6);

		ReorderLinkedList r=new ReorderLinkedList();
		r.reorderList(n);

	}
	  public void reorderList(ListNode head) {
	       
	        ListNode pre=head;
	        ListNode post=head;
	        ListNode prev=null;
	        while(post!=null&&post.next!=null){
	        	prev=pre;
	            pre=pre.next;
	            post=post.next.next;
	        }
	      //  prev.next=null;
	        ListNode middle=pre;
	        ListNode t=null;
	        while(middle!=null){
	            
	           ListNode temp=middle.next;
	           
	            if(t==null){
	            t=middle;
	            t.next=null;
	            }else{
	                middle.next=t;
	            }
	            t=middle;
	            middle=temp;
	        }
	        ListNode first=head;
	        while(t!=null){
	           ListNode f1=first.next;
	           ListNode f2=t.next;
	            first.next=t;
	            if(f1==null||t==null)break;
	            t.next=f1;
	            first=f1;
	            t=f2;
	            
	        }
	        
	    }
}
