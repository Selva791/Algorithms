package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
	public static void main(String[] args) {
		IntegerToEnglishWords m=new IntegerToEnglishWords();
		System.out.println(m.numberToWords(1200000));
	}
	public String numberToWords(int num) {
        Map<Integer,String> onetoTen=new HashMap<>();
    onetoTen.put(0,"");
    onetoTen.put(1,"One");
    onetoTen.put(2,"Two");
    onetoTen.put(3,"Three");
    onetoTen.put(4,"Four");
    onetoTen.put(5,"Five");
    onetoTen.put(6,"Six");
    onetoTen.put(7,"Seven");
    onetoTen.put(8,"Eight");
    onetoTen.put(9,"Nine");
    onetoTen.put(10,"Ten");
           Map<Integer,String> tentoTwenty=new HashMap<>();
    tentoTwenty.put(11,"Eleven");
    tentoTwenty.put(12,"Twevle");
    tentoTwenty.put(13,"Thirteen");
    tentoTwenty.put(14,"Fourteen");
    tentoTwenty.put(15,"Fifteen");
    tentoTwenty.put(16,"Sixteen");
    tentoTwenty.put(17,"Seventeen");
    tentoTwenty.put(18,"Eighteen");
    tentoTwenty.put(19,"Nineteen");
         Map<Integer,String> twenty=new HashMap<>();
    twenty.put(20,"Twenty");
    twenty.put(30,"Thirty");
    twenty.put(40,"Fourty");
    twenty.put(50,"Fifty");
    twenty.put(60,"Sixty");
    twenty.put(70,"Seventy");
    twenty.put(80,"Eighty");
    twenty.put(90,"Ninety");

  Map<Integer,String> hundredsAndThousand=new HashMap<Integer,String>(){
      {
      put(1, "");
        put(2, "Hundred");
        put(3, "Thousand");
        put(4, "Thousand");
        put(5, "Thousand");
        put(6, "Million");
        put(7, "Million");
        put(8, "Million");
        put(9, "Billion");
        put(10, "Billion");
        put(11, "Billion");
        put(12, "Trillion");
        put(13, "Trillion");
        put(14, "Trillion");
      }
  };

  String st="";
  String word=String.valueOf(num);
  int len =word.length();
  int count=0;
  
  for(int i=0;i<word.length();i++) {
	  
	  char temp=word.charAt(len-i-1);
	  
	  if(count==0) {
		  int s=Integer.valueOf(temp+"");
		  if(s!=0) {
		 st=(onetoTen.get(s));
 
		  }

		  
	  }	else if(count>0&&count==1) {
		  int s=Integer.valueOf(temp+"");
		  if(s==1) {
			  String splited[]=st.split(" ");
			  char p=word.charAt(len-i);
			  int t=Integer.valueOf(temp+""+p+"");
			  splited[0]=tentoTwenty.get(t);
			  StringBuilder sb=new StringBuilder();
			  for (int j = 0; j < splited.length; j++) {
				sb.append(splited[j]+" ");
			}
			  st=sb.toString();
			  
		  }else if(s!=0) {
			  int s1=Integer.valueOf(temp+"0");

			  st=twenty.get(s1)+" "+st;
			  

		  }


	  }else if(count>1) {
		  int s=Integer.valueOf(temp+"");

		  if(count==2&&s!=0) {
			  st=hundredsAndThousand.get(2)+" "+st;
			  st=onetoTen.get(s)+" "+st;
			  
		  }else if(s!=0)  {
			  
		  st=hundredsAndThousand.get(i)+" "+st;
		  st=onetoTen.get(s)+" "+st;
			  
		  }else if(s==0) {
			  char tp=word.charAt(len-i);

			  if(tp!=0) {
				  st=hundredsAndThousand.get(i)+" "+st;
				  st=onetoTen.get(s)+" "+st;
					  
				  
			  }
			  
		  }

	  }
	  count++;

	  if(count>3) {
		  count=1;
	  }
  }
  return st;
}

}
