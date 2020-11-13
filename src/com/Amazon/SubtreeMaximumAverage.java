package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class SubtreeMaximumAverage {
	static MAryTreeNode root;
	static class MAryTreeNode{
		int val;
		List<MAryTreeNode> children;
		MAryTreeNode(int data){
			val=data;
			children=new ArrayList<MAryTreeNode>();
		}
	}
public static void main(String[] args) {
	SubtreeMaximumAverage m=new SubtreeMaximumAverage();
	root=new MAryTreeNode(10);
	root.children.add(new MAryTreeNode(1));
	root.children.add(new MAryTreeNode(12));
	//root.children.add(new MAryTreeNode(4));
	//root.children.get(0).children.add(new MAryTreeNode(1));
	//root.children.get(0).children.add(new MAryTreeNode(2));
	//root.children.get(1).children.add(new MAryTreeNode(4));
	//root.children.get(1).children.add(new MAryTreeNode(-2));



	
	MAryTreeNode r=m.subtreeMaxAvg(root);
	System.out.println(r);
}
double max = Integer.MIN_VALUE;
MAryTreeNode maxNode = null;

public MAryTreeNode subtreeMaxAvg(MAryTreeNode root) {
   if (root == null) return null;
   helper(root);
   return maxNode;
}

private double[] helper(MAryTreeNode root) {
   if (root == null) return new double[] {0, 0};

   double curTotal = root.val;
   double count = 1;
   for (MAryTreeNode child : root.children) {
       double[] cur = helper(child);
       curTotal += cur[0];
       count += cur[1];
   }        
   double avg = curTotal / count;
   if (count > 0 && avg > max) { //taking "at least 1 child" into account
       max = avg;
       maxNode = root;
   }
   return new double[] {curTotal, count};
}
}
