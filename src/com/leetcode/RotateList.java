package com.leetcode;

import com.leetcode.LinkedListOddEven.ListNode;

public class RotateList {
	
	public static void main(String[] args) {
		RotateList r=new RotateList();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		r.rotateRight(head, 2);
	}
	 public ListNode rotateRight(ListNode head, int k) {
	        if(head==null){
	            return null;
	        }
	        if(k==0)return head;
	        int h=0;
	    ListNode temp=head;
	        while(temp!=null){
	            h++;
	         temp=temp.next;
	        }
	        if(h==1)return head;
	        int r=k%h;
	        
	        r=h-r;
	        
	        ListNode node=null;
	         ListNode real=head;
	        int index=0;
	        while(index<r){
	            head=head.next;
	            index++;
	        }
	        
	        node=head;
	        while(head!=null&&head.next!=null){
	            head=head.next;
	        }
	        
	         head.next=real;
	         ListNode n2=node;
	       // System.out.println(h);
	        while(h-1> 0){
	            node=node.next;
	            h--;
	        }
	       node.next=null;
	       // System.out.println(n2.next.next.val);
	        return n2;
	    }
}
