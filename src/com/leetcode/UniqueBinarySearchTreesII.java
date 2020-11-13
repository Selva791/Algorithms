package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		UniqueBinarySearchTreesII u=new UniqueBinarySearchTreesII();
		u.generateTrees(3);
	}
	List<TreeNode>result;
    public List<TreeNode> generateTrees(int n) {
        result=new ArrayList<>();
        for(int i=0;i<=n;i++){
            helper(i,n,i);
        }
       
        return result;
    }
   public TreeNode helper(int low,int high,int start){
       if(low>high)return null;
       
       //int mid=low+(high-low)/2;
       TreeNode node=new TreeNode(low);
       
       node.left=helper(low,high-1,start);
       node.right=helper(low+1,high,start);
       if(low==start)result.add(node);
       return node;
       
   }
}
