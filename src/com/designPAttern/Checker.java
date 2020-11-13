package com.designPAttern;

public interface Checker {
	void good();
	default void goo() {
		System.out.println("Good");
	}
}
