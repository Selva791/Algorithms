package com.Amazon;

public class LongestStringWithout3ConsecutiveCharacters {
public static void main(String[] args) {
	LongestStringWithout3ConsecutiveCharacters c=new LongestStringWithout3ConsecutiveCharacters();
	System.out.println(c.longestDiverseString(1, 1, 7));
}
public String longestDiverseString(int a, int b, int c) {
    StringBuilder sd=new StringBuilder();
     int total=a+b+c;
     int curA=0;
     int curB=0;
     int curC=0;
     for(int i=0;i<total;i++){
         
         if(a>=b&&a>=c&&curA<2||(a>0&&(curC==2||curB==2))){
            sd.append("a");
             a--;
             curA++;
             curB=0;
             curC=0;
         }else if(b>=a&&b>=c&&curB<2||(b>0&&(curA==2||curC==2))){
              sd.append("b");
             b--;
             curB++;
             curA=0;
             curC=0;
         }else if(c>=b&&c>=a&&curC<2||(c>0&&(curA==2||curB==2))){
              sd.append("c");
             c--;
             curC++;
             curA=0;
             curB=0;
         }
         
     }
     
 
            return sd.toString();
}
}
