package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxProductOfASplitedBinaryTree {
		public static void main(String[] args) {
			MaxProductOfASplitedBinaryTree m=new MaxProductOfASplitedBinaryTree();
			TreeNode n=new TreeNode(1);
			n.right=new TreeNode(2);
			n.right.left=new TreeNode(3);
			n.right.right=new TreeNode(4);
			n.right.right.left=new TreeNode(5);
			n.right.right.right=new TreeNode(6);
			m.maxProduct(n);
			
		}
		
		 public int maxProduct(TreeNode root) {
		        List<Integer> list=new ArrayList<>();
		         maxValue(root,list);
		      //  System.out.println(list);
		        int n=list.size();
		        int arr[]=new int[n];
		        for(int i=0;i<n;i++){
		            arr[i]=list.get(i);
		        }
		        int sum[]=new int[n];
		        sum[0]=arr[0];
		        int total=0;
		        for(int i=1;i<n;i++){
		            sum[i]=(arr[i]+sum[i-1]);
		        }
		        total=sum[n-1];
		        int max=Integer.MIN_VALUE;
		        for(int i=0;i<n;i++){
			 int prod=(int) ((sum[i]*(total-sum[i]))%(Math.pow(10,9)+7));
		                //    System.out.println(prod);

		            if(max<prod){
		                max=prod;
		            }
		        }
		             return max;
		        
		    }
		    
		   public void maxValue(TreeNode root,List<Integer> list){
		       if(root==null){
		           return;
		       }
		       
		       maxValue(root.left,list);
		        
		       maxValue(root.right,list);
		       list.add(root.val);
		       return ;
		       
		   }
}
