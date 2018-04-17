package com.study.oftenused;

public class StringCount {

	public static void main(String[] args) {
		//String s = "feij348HJG93KL7*(&3fnekJIOl3489^*jfe";
		String s="ADGZabz3847*^*(";
		byte[] byt = s.getBytes();
		int up = 0;
		int low = 0;
		int others = 0;
		for (int i=0; i<byt.length; i++) {
			if (byt[i] >= 'A' && byt[i] <='Z') {
				up++;
			} else if (byt[i] >= 'a' && byt[i] <='z')
			{
				low++;
			} else {
				others++;
			}
		}
		
		System.out.println("大写字母数："+up);
		System.out.println("小写字母数："+low);
		System.out.println("其他字母数："+others);
	}

}
