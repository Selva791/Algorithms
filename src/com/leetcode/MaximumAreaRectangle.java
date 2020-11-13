package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class MaximumAreaRectangle {
	public static void main(String[] args) {
		MaximumAreaRectangle m=new MaximumAreaRectangle();
		int[][]points= {{0,1},{1,3},{3,3},{4,4},{1,4},{2,3},{1,0},{3,4}};
		m.minAreaRect(points);
	}
	 public int minAreaRect(int[][] points) {
	        int n=points.length;
	        TreeMap<Integer,ArrayList<int[]>> mp=new TreeMap<>();

	        for(int p[]:points){
	            ArrayList<int[]>t=new ArrayList<>();
	            if(mp.get(p[0])!=null){
	              ArrayList<int[]>ts=mp.get(p[0]);
	                ts.add(p);
	                mp.put(p[0],ts);
	            }else{
	                t.add(p);
	                mp.put(p[0],t);
	            }
	            
	        }
	        TreeMap<Integer,ArrayList<int[]>> mp1=new TreeMap<>(mp);

	        List<int[]> temp=null;
	        List<Integer> result=new ArrayList<>();
	        
	        for(int k:mp.keySet()){
	            List<int[]> res=mp.get(k);
	            for(int kp:mp1.keySet()) {
	            	temp=mp1.get(kp);
	            	if(kp==k)continue;
	            	 if(res.size()>1&&temp.size()>1){
	  	               if(temp.get(0)[1]==res.get(0)[1]&&temp.get(1)[1]==res.get(1)[1]){
	  	                    int x=temp.get(0)[0]-res.get(0)[0];
	  	                   int y=temp.get(0)[1]-temp.get(1)[1];
	  	                   if(x*y>0)
	  	                   result.add(x*y);
	  	                }
	  	            }
	  	            
	            }
	           
	        }
	        Collections.sort(result);
	        return result.get(0);
	    }

}
