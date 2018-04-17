package com.study.oftenused;

public class StringBufferStudy {

	public static void main(String[] args) {
		String s1 = "12345623436654";
		String s2 = "78941356768789865679098984524";
		StringBuffer sb1;
		StringBuffer sb2;
		
		if (s1.length() > s2.length()) {
			sb1 = new StringBuffer(s1);
			sb2 = new StringBuffer(s2);
		} else {
			sb2 = new StringBuffer(s1);
			sb1 = new StringBuffer(s2);
		}
		
		sb1 = sb1.reverse();
		sb2 = sb2.reverse();
		
		int len1 = sb1.length();
		int len2 = sb2.length();
		
		int temp = 0;
		int a=0,b=0;
		
		int length = len1 > len2 ? len1 : len2;
		StringBuffer s = new StringBuffer();
		
		for (int i=0; i<length; i++) {
			if (i >= len2) {
				a = Integer.parseInt(sb1.charAt(i)+"");
				b = 0;
			}
			else {
				a = Integer.parseInt(sb1.charAt(i)+"");
				b = Integer.parseInt(sb2.charAt(i)+"");
			}
			
			temp = a+b+temp;
			s.append(temp%10);
			temp = temp/10;
		}
		
		if (temp != 0)
			s.append(temp);
		
		s = s.reverse();
		System.out.println(s);
	}

}
