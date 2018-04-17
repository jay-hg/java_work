package com.study.oftenused;

public class StrCount {

	public static void main(String[] args) {
		String s = "javaweojjavaoewjavaavajavew";
		String ss = "java";
		int count = 0;
		String str;
		for (int i=0; i<s.length()-ss.length(); i++) {
			str = s.substring(i, i+ss.length());
			if (str.equals(ss)) {
				count ++;
			}
		}
		
		System.out.println(count);
	}

}
