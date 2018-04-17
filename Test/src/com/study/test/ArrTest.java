package com.study.test;

public class ArrTest {

	public static void main(String[] args) {
		
		if (args.length < 3) {
			System.out.println("error:");
			System.exit(-1);
		}

		double d1 = 0;
		double d2 = 0;
		
		try {
			d1 = Double.parseDouble(args[0]);
			d2 = Double.parseDouble(args[2]);
			
		} 
		catch (NumberFormatException e) {
			System.out.println("ÇëÊäÈëÊý×Ö");
			System.exit(-1);
		}
		
		double d = 0;
		if (args[1].equals("+")) {
			d = d1 + d2;
		}
		else if (args[1].equals("-")) {
			d = d1 - d2;
		}
		else {
			System.out.println("Error:");
			System.exit(-1);
		}

		System.out.println(d);
	}

}
