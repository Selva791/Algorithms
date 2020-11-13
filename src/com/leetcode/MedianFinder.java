package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
//different approach by me for leetcode 
//https://leetcode.com/problems/find-median-from-data-stream/submissions/
public class MedianFinder {
	static double median = 0;
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) {
		int arr[] = {6,10,2,6,5,0,6,3,1,0,0};
			//{1};
				//{6,10,2,6,5,0,6,3,1,0,0}; 
			//{ 5, 15, 10, 20, 3 };
		MedianFinder mf = new MedianFinder();
		for (int i = 0; i < arr.length; i++) {
			mf.addNum(arr[i]);
			System.out.println(mf.findMedian());

		}
	}

	public MedianFinder() {
		median=0.0;
	}

	public void addNum(int num) {
	
		int total = (max.size() + min.size());

		if(total%2>0) {
			if (median > num) {
				max.add(num);
			} else if (median < num) {
				min.add(num);

			}else if(median==num) {
				min.add(num);
			}
			int maxSize=max.size();
			int minSize=min.size();
		if(maxSize>minSize) {
			min.add(max.remove());
		}else if(maxSize<minSize) {
			max.add(min.poll());
		}
		}else {
		if (median == 0.0) {
			median = num;
			max.add(num);

		} else if (median > num) {
			max.add(num);
		} else if (median < num) {
			min.add(num);

		}else if(median==num) {
			min.add(num);
		}
		}
	}

	public double findMedian() {
		int len = 0;
		int maxSize=max.size();
		int minSize=min.size();
		int total = (max.size() + min.size());
		int mid=total/2;
		if(mid==0) {
			return median;
		}
		if (total % 2 > 0) {
			if(maxSize>minSize) {
				return max.peek();
				
				}
			if(minSize>mid) {
				return min.peek();
			}
			
		}else {
			double t=0;
			t=((double)max.peek()+(double)min.peek())/2;
			median=t;
			return median;
		}
		return 0;

	}
}
