package com.leetcode;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ClosestPOintToOrigin {
public static void main(String[] args) {
	ClosestPOintToOrigin c=new ClosestPOintToOrigin();
	//[[-5,4],[-6,-5],[4,6]]
	//2
	int a[][]= {{-5,4},{-6,-5},{4,6}};
	System.out.println(c.kClosest(a, 2));
	
}
public int[][] kClosest(int[][] points, int K) {
    int n=points.length;
    Map<Double,ArrayList<int[]>> mp=new TreeMap<>();
    for(int i=0;i<n;i++){
        int pt[]=points[i];
        int x=Math.abs(0-pt[0]);
        int y=Math.abs(0-pt[1]);
        int z=(x*x)+(y*y);
        Double r=Math.sqrt(z);
        if(mp.get(r)==null){
           ArrayList<int[]>list=new ArrayList<>();
            list.add(pt);
            mp.put(r,list);

        }else{
            ArrayList<int[]>list=mp.get(r);
            list.add(pt);
            mp.put(r,list);
           
        }
        
        
    }
    
    ArrayList<int[]> p=new ArrayList<>();
    Integer keye=0;
    int c=1;
    boolean flag=false;
    for(Map.Entry<Double,ArrayList<int[]>> key:mp.entrySet()){
    	for(int[] arr:key.getValue()) {
    		   if(c<K){
                   p.add(arr);
                  
               } if(c==K) {
            	   p.add(arr);
                   flag=true;
                  
            	   
               }
            c++;
    		
    	}
    	if(flag==true)break;
        
    }
    int len=p.size();
    int f[][]=new int[len][2];
        for(int i=0;i<len;i++){
            
            f[i]=p.get(i);
            
        }
    return f;
    
}
}
