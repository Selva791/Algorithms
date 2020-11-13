package com.leetcode;

public class MinimumWindow {
	public static void main(String[] args) {
		System.out.println(minWindow("acbbaca","aba"));
		//"acbbaca"
		//"aba"
		
	}
	public static String minWindow(String s, String t) {
        int [] value=new int[256];
        int []dps=new int[256];
        int len =s.length();
        int tlen=t.length();
        for(int i=0;i<len;i++){
            int a=s.charAt(i);
            value[a]++;
        }
           for(int i=0;i<tlen;i++){
            int a=t.charAt(i);
            dps[a]++;
           
        }
           for(int i=0;i<tlen;i++) {
               int a=t.charAt(i);

        	   if(value[a]>=dps[a]) {
               	
               }else {
            	   return "";
               }
           }
           int []comp=new int[256];

        int start=0;
        int end=len;
        int j=0;
         for(int i=0;i<len;i++){
             int y=0;
             
             
             for(int m=0;m<tlen;m++){
                 int a=t.charAt(m);
                 comp[a]++;
                
             }
             if(i>=1&&comp[s.charAt(i-1)]>0){
            comp[s.charAt(i-1)]--;
             }
             int h=s.charAt(i);
               if(comp[h]>0){
              	comp[h]--;

               j++;
               y=1;
               
                while(j<len&&y<tlen){
                    if(comp[s.charAt(j)]>0){
                    	comp[s.charAt(j)]--;
                        y++;
                        j++;
                    }else{
                        j++;
                    }
                }
               }
             if((j-i)<end-start&&y==tlen){

                 start=i;
                 end=j;
             }
             for(int m=0;m<tlen;m++){
                 int a=t.charAt(m);
                 if(comp[a]>=1)
                 comp[a]--;
                
             }
             
         }
        return s.substring(start,end);
    }
}
