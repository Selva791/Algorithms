package com.leetcode;

public class FindMinimumInRotatedSortedArrayII {
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII f=new FindMinimumInRotatedSortedArrayII();
		int nums[]= {10,1,10,10,10};
			//{1,3,3};
			//{1,1,1};
		System.out.println(f.findMin(nums));
	}

	public int findMin(int[] nums) {
		int n = nums.length;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid < high && nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];

			} else if (mid > 0 && mid + 1 < high && (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1])) {
				return nums[mid];

			}
			if (mid == 0) {
				return nums[0];
			}
			if (mid == n - 1) {
				return nums[n - 1];

			}
			if (nums[mid] > nums[high]) {
				low = mid+1;
			} else if (nums[mid] <nums[high]) {
				high = mid-1;
			}else {
				high--;
			}

		}
		return -1;
	}
}
