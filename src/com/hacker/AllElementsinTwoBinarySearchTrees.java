package com.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leetcode.MiniValueBetweeBSTNodes.TreeNode;

public class AllElementsinTwoBinarySearchTrees {
	public static void main(String[] args) {

	}

	List<Integer> arr1;

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		arr1 = new ArrayList<>();
		sortedArray(root1);
		sortedArray(root2);
		int arr[] = shellSort(arr1.stream().mapToInt(i->i).toArray());
		List<Integer> result=new ArrayList<>();
		for(int a:arr)result.add(a);
		return result;

	}

	public int[] shellSort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2; i >= 1; i--) {
			for (int j = 0; j < n; j++) {
				int g = j + i;
				if (g < n && arr[j] > arr[g]) {
					int temp = arr[j];
					arr[j] = arr[g];
					arr[g] = temp;

				}
			}

		}
		return arr;

	}

	public void sortedArray(TreeNode root) {
		if (root == null)
			return;
		sortedArray(root.left);
		arr1.add(root.val);
		sortedArray(root.right);
		
	}
}
