package com.designPAttern;

public abstract class Computer {
	private String price="200000";

	 abstract String spec();
	 
	 @Override
	 public String toString() {
		return this.spec()+" Perfect finish";
		 
	 }
	 

}
