package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
	public static void main(String[] args) {
		CourseScheduleIII c=new CourseScheduleIII();
		int cr[][]= {{9,14},{7,12},{1,11},{4,7}};
			//{{7,16},{2,3},{3,12},{3,14},{10,19},{10,16},{6,8},{6,11},{3,13},{6,16}};
			//{{5,5},{4,6},{2,6}}; 
			//{{100,200},{200,1300},{1000,1250},{2000,3200}};
		System.out.println(c.scheduleCourse(cr));
	}
	 public int scheduleCourse(int[][] courses) {
	        int n=courses.length;
	        int arr[]=new int[n];
	       // int total[]
	        for(int i=0;i<n;i++){
	            int c[]=courses[i];
	            arr[i]=c[1]-c[0];
	        }
	        Arrays.sort(courses,(a,b)->a[0]==b[0]?(a[1]-b[1]):(a[0]-b[0]));
	       // Arrays.sort(arr);
	        //  Arrays.sort(courses,(a,b)->(a[1]-a[0])==(b[1]-b[0])?(a[0]-b[0]):(a[1]-a[0])-(b[1]-b[0]));
	        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
	        int count=0,ans=0,max=0;
	        int prev[]=new int[n];
	        for(int i=0;i<n;i++){
	            int c[]=courses[i];
	            if(count+c[0]<=c[1]) {	
	            	count+=c[0];
	            	pq.offer(c[0]);
	            	ans++;
	            }else if(count+c[0]>c[1]){
	            	max=Math.max(max,ans);
	            	if(count+c[0]>c[1]&&!pq.isEmpty()&&pq.peek()>c[0]) {
	            		count-=pq.poll();
	            		ans--;
	            	}
	            	if(count+c[0]<=c[1]) {
	            		pq.offer(c[0]);
		            	count+=c[0];
		            	ans++;
	            	}
	            	
	            }
	            
	        }
	        max=Math.max(max,ans);
	        return max;
	        
	    }
}



