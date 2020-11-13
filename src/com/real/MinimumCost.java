package com.real;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MinimumCost {
	    static int solve(int N, int M){
	       // Write your code here
	        int j=2;
	        int i=2;
	        while(j<N) {
	        	if(N%j==0) {
	        		//j+=2;
	        		i=j;
	        	}
	        	j+=2;
	        }
	       int t=N;
	        int total=0;
	       while(N<M){
	    	 
	    	   int r=N/2;
	    	   while(r<N&&r>0) {
	    		  
	    		   if((N+r<=M)&&r%2==0 && r<N && ((N+r)%r==0)){
		 	              
		               total=total+(N/r);
		               N+=r;
		               break;
		           } 
	    		  r--;
	    	   }
	    	   if(t==N) {
		    		break;  
		    	  }
	         
	       }
	       return total==0?-1:total;
	    }
	    
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	        int T = Integer.parseInt(br.readLine().trim());
	        for(int t_i = 0; t_i < T; t_i++)
	        {
	            String[] line = br.readLine().split(" ");
	            int N = Integer.parseInt(line[0]);
	            int M = Integer.parseInt(line[1]);

	            int out_ = solve(N, M);
	            System.out.println(out_);
	            
	         }

	         wr.close();
	         br.close();
	    }
	}


