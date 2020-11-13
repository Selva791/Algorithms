package com.leetcode;

public class FindClosestPalindrome {
		public static void main(String[] args) {
			FindClosestPalindrome f=new FindClosestPalindrome();
			f.nearestPalindromic("1213");
		}
		public String nearestPalindromic(String n) {
	        int len=n.length();
	        if(len==1){
	            return String.valueOf(Integer.valueOf(n)-1);
	        }
	        
	        long n1=Long.parseLong(n);
	        long c=Long.parseLong(n.substring(0,1));
	        if(n1<=10||(n1%10==0&&n1!=0&&Long.parseLong(n.substring(1))==0)){
	            return ""+(n1-1);
	                
	        }
	         if(n1==11||(n1%10==1&&n.charAt(0)=='1'&&Long.parseLong(n.substring(1,len-1))==0)){
	            return ""+(n1-2);
	                
	        }
	        
	        long n2=Long.parseLong(n);
	            
	            while(n2>0){
	                long re=n2%10;
	                if(re!=9){
	                    break;
	                }
	                n2=n2/10;
	            }
	        if(n2==0){
	           long n3=Long.parseLong(n); 
	            n3=n3+2;
	            return String.valueOf(n3);
	        }
	        
	        boolean evenFlag=len%2==0?true:false;
	        String palindrome=evenFlag==true?n.substring(0,len/2):n.substring(0,1+len/2);
	        long palinvalue=Long.parseLong(palindrome);
	        long equal=helper(""+palinvalue,evenFlag);
	        long equalDiff=Math.abs(n1-equal);
	        
	        long small=helper((""+(palinvalue-1)),evenFlag);
	        long smallDiff=Math.abs(n1-small);
	        
	        long bigger=helper((""+(palinvalue+1)),evenFlag);
	        long biggerDiff=Math.abs(n1-bigger);
	        
	        long close=biggerDiff<smallDiff?bigger:small;
	        long diff=Math.min(biggerDiff,smallDiff);
	       // System.out.println(equalDiff+" "+smallDiff+" "+biggerDiff);
	        if(equalDiff!=0){
	         if(diff==equalDiff){
	             close=Math.min(close,small);
	             
	         }else if(diff>equalDiff){
	             return equal+"";
	         }
	           
	        }
	        
	        return close+"";
	        
	    }
	    public long helper(String sum,boolean even){
	        StringBuilder sb=new StringBuilder(sum).reverse();
	        String temp=even==true?sum+sb.toString():sum+sb.deleteCharAt(0).toString();
	        
	        return Long.parseLong(temp);
	    }
}
