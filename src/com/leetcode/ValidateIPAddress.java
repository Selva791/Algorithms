package com.leetcode;

public class ValidateIPAddress {
	public static void main(String[] args) {
		ValidateIPAddress v = new ValidateIPAddress();
		System.out.println(v.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
	}

	public String validIPAddress(String IP) {
				int n=IP.length();
				if(IP.charAt(0)==':'||IP.charAt(n-1)==':') {
					return "Neither";
				}else if(IP.charAt(0)=='.'||IP.charAt(n-1)=='.') {
					return "Neither";

				}
		        if(IP.contains(".")){
		    if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])")){
		                return "IPv4";
		            }
		           
		            
		            return "Neither";
		        }else if(IP.contains(":")){
		           if(IP.matches("((([0-9a-fA-F]){1,4})\\:){7}(([0-9a-fA-F]){1,4})")){
		                return "IPv6";

		           }
		        }
		        return "Neither";
		    }
}
