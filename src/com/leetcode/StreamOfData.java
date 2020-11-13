package com.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class StreamOfData {
	public static void main(String[] args) {
		StreamOfData st=new StreamOfData();
		st.addNum(1);
		st.addNum(2);
		System.out.println(st.findMedian()); //-> 1.5
		st.addNum(6);
		st.addNum(4);
		st.addNum(3);
		st.addNum(8);
		System.out.println(st.findMedian());// -> 2
	}
	
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());


	public void addNum(int num) {
	
	int total=(min.size()+max.size());
        if(total%2>0){
          min.offer(num);
         max.offer(min.poll());
        }else{
            max.offer(num);
            min.offer(max.poll());
        }
        
	}

	public double findMedian() {
      //  int total=();
         if(min.size()==max.size()){
            return (min.peek()+max.peek())/2;
        }else {
            return min.peek();
        }
    }

	/*static double median = 0;
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());


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

	}*/
	/*private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> large = new PriorityQueue<>();
	private boolean even = true;

	public double findMedian() {
	    if (even)
	        return (small.peek() + large.peek()) / 2.0;
	    else
	        return small.peek();
	}

	public void addNum(int num) {
	    if (even) {
	        large.offer(num);
	        small.offer(large.poll());
	    } else {
	        small.offer(num);
	        large.offer(small.poll());
	    }
	    even = !even;
	}*/
}
