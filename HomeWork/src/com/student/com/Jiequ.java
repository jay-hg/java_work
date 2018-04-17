package com.student.com;

public class Jiequ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long example=376857987;
		String s=String.valueOf(example);
		
		String out = s.substring(s.length()-7, s.length()-3);
		System.out.println("输出的结果为："+out);

	}

}
