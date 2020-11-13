package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
		public static void main(String[] args) {
			TimeBasedKeyValueStore t=new TimeBasedKeyValueStore();
			t.set("foo","bar",1);
			t.get("foo",1);
			t.get("foo",3);
			t.set("foo","bar2",4);
			t.get("foo",4);
			t.get("foo",5);
		}
		 class Data{
		        int time;
		        String value;
		        Data(int time,String value){
		            this.time=time;
		            this.value=value;
		        }
		    }
		    /** Initialize your data structure here. */
		    Map<String,List<Data>> mp=new HashMap<>();
		    
		   
		     
		    
		    public void set(String key, String value, int timestamp) {
		        if(!mp.containsKey(key)){
		            mp.put(key,new ArrayList<>());
		        }
		        mp.get(key).add(new Data(timestamp,value));
		            
		    }
		    
		    public String get(String key, int timestamp) {
		            if(!mp.containsKey(key))return "";
		        return binarySearch(mp.get(key),timestamp);
		    }
		    public String binarySearch(List<Data> list,int time){
		        int low=0; int high=list.size()-1;
		        
		        while(low<high){
		            int mid=low+(high-low)/2;
		            if(list.get(mid).time==time)return  list.get(mid).value;
		            
		            if(list.get(mid).time<time){
		                if(list.get(mid+1).time>time){
		                    return  list.get(mid).value;
		                }
		                low=mid+1;
		            }else{
		                high=mid-1;
		            }
		            
		        }
		        return list.get(low).time<time?list.get(low).value:"";
		    }
}
