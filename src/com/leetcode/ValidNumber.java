package com.leetcode;

public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber v = new ValidNumber();
		System.out.println(v.isNumber("6+1"));
	}

	 public boolean isNumber(String s) {
	        s=s.trim();
	        int n=s.length();
	        if(s.equals(""))return false;
	        if(s.equals(" "))return false;
	        boolean numAfterE=false;
	        boolean check=false;
	        boolean pointSeen=false;
	        for(int i=0;i<n;i++){
	            char c=s.charAt(i);
	            if(c>='0'&&c<='9'){
	               check=true; 
	                numAfterE=true;
	            } else if(c=='e'){
	                if(!check)
	                    return false;
	                
	                numAfterE=false;
	            }else if(c=='.'){
	                if(pointSeen)return false;
	                
	                pointSeen=true;
	                if((i+1)<n && s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
	                    
	                }else if(check){
	                  check=false;
	                }else{
	                    return false;
	                }
	            }else if(c=='-'||c=='+'||c=='/'){
	                
	            }
	            else{
	                return false;
	            }
	        }
	        return numAfterE;
	    }
}
