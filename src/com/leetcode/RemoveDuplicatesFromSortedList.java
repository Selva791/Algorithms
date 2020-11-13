package com.leetcode;

import com.leetcode.LinkedListOddEven.ListNode;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList r=new RemoveDuplicatesFromSortedList();
		ListNode n=new ListNode(1);
		n.next=new ListNode(1);
		//n.next.next=new ListNode(1);
		//n.next.next.next=new ListNode(3);
		//n.next.next.next.next=new ListNode(4);
		//n.next.next.next.next.next=new ListNode(4);
		//n.next.next.next.next.next.next=new ListNode(5);
		r.deleteDuplicates(n);
	}
	 public ListNode deleteDuplicates(ListNode head) {
	       
	        return  helper(head);
	    }
	    public ListNode helper(ListNode head){
	        if(head==null){
	            return null;
	        }
	        ListNode newNode=new ListNode(0);
	        newNode.next=head;
	        
	        ListNode prev= newNode;
	        ListNode mid=head;
	        ListNode step=head.next;
	       
	        while(prev!=null&&step!=null){
	           int data=mid.val;
	           if(data==step.val) {
	        	   while(step!=null&&step.val==data){
	  	             if(step!=null&&mid!=null&&data==step.val){
	  	               step=step.next;
	  	                 
	  	              }
	  	            
	  	            }
	        	   mid=step;
	        	   if(mid!=null)step=mid.next;
	        	   prev.next=mid;
	           }else {
	        	   prev=mid;
		           mid=step;
		           
		           if(step!=null)step=mid.next;  
	           }
	          
	            
	        }
	        return newNode.next;
	    }
}
