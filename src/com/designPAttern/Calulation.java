package com.designPAttern;

public class Calulation {

	public static void main(String[] args) {
		CalculationFactory cf=new CalculationFactory();
		Computer ct=cf.getdetails("HP");
		System.out.println(ct.spec());
		System.out.println(ct);
		
	}
}
