package com.leetcode;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandamPoinInNonOverlappingRectangles {
	public static void main(String[] args) {
		RandamPoinInNonOverlappingRectangles r=new RandamPoinInNonOverlappingRectangles();
		int rects[][]= {{-2,-2,-1,-1},{1,0,3,0}};
		r.Solution(rects);
		int a[]=r.pick();
		System.out.println(a[0]+" "+a[1]);
		int b[]=r.pick();
		System.out.println(b[0]+" "+b[1]);

	}
    int arr[][];
    TreeMap<Integer,Integer> value;
Random rm;
int sum=0;
   public void Solution(int[][] rects) {
    arr=rects;
    value=new TreeMap<>();
    rm=new Random();
    sum=0;
    for(int i=0;i<rects.length;i++){
        int r[]=rects[i];
        sum+=(r[2]-r[1]+1)*(r[3]-r[1]+1);
        value.put(sum,i);
    }
    
}
 public int[] calculate(int array[]){
  int left=array[0],right=array[2], bot=array[1], top=array[3];
    
    return new int[]{left+rm.nextInt(right-left+1),bot+rm.nextInt(top-bot+1)};
    
}

public int[] pick() {
     int c= value.ceilingKey(rm.nextInt(sum)+1);
    return calculate(arr[value.get(c)]);
}

}
