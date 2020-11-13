package com.leetcode;

public class FindFirstAndLastPositionofElementInSortedArray {
	public static void main(String[] args) {
		FindFirstAndLastPositionofElementInSortedArray f=new FindFirstAndLastPositionofElementInSortedArray();
		int nums[]= {5,7,7,8,8,10};
		int target=8;
		System.out.println(f.searchRange(nums, target));
	}
	public int[] searchRange(int[] nums, int target) {
		int n = nums.length;
		int high = n - 1;
		int low = 0;
		int cur = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > target) {
				high--;
			} else if (nums[mid] < target) {
				low++;
			} else if (mid + 1 <=high && nums[mid] == target && nums[mid + 1] == target) {
				low++;
			} else if (mid + 1 <= high && nums[mid] == target && nums[mid + 1] != target) {
				cur = mid;
				break;
			}
		}
		System.out.println(cur);
		int result[] = new int[2];
		result[0] = cur;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > target) {
				high--;
			} else if (nums[mid] < target) {
				low++;
			} else if (mid - 1 <=high && nums[mid] == target && nums[mid - 1] == target) {
				high--;
			} else if (mid + 1 <= high && nums[mid] == target && nums[mid - 1] != target) {
				cur = mid;
				break;
			}
		}
		result[1] = cur;
		return result;
	}
}
