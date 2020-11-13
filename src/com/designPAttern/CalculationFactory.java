package com.designPAttern;

public class CalculationFactory {
	public Computer getdetails(String value) {
		if(value.equals("HP")) {
			return new HP();
		}else if(value.equals("Lenovo")) {
			return new Lenovo();

		}else if(value.equals("Apple")) {
			return new Apple();

			
		}
		return null;
		
	}

}
