package com.study.test;

public class Test {

	public static void main(String[] args) {
		double in = 2.95; 
		double num = in*100+0.5;
		String numToStr = String.valueOf(num).trim();
		String[] value = numToStr.split("\\.");
		System.out.println(value[0]);
		System.out.println(value[1]);
	}

}
