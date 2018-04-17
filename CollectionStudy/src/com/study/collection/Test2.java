package com.study.collection;

import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=2,b=3;
		System.out.println(a+"  "+b);
		
		swapAtomicInteger(a,b);
		System.out.println(a+"  "+b);
	}

	public static void swapAtomicInteger(int x,int y)
	{
		AtomicInteger a=(Integer)x;
		AtomicInteger b=(Integer)y;
		int temp=a.get();
		a.set(b.get());
		b.set(temp);
	}
}
