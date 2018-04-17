package com.study.oftenused;

public class StringStudy {

	public static void main(String[] args) {
		char[] byt = {'j', 'a', 'v', 'a'};
		String s = new String(byt,0,4);
		System.out.println(s);
		System.out.println(s.length());

		System.out.println(s.indexOf("a"));
		System.out.println(s.charAt(3));
		String s2 = s.replace("a", "b");
		System.out.println(s2);
	}

}
