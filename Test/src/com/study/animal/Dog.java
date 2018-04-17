package com.study.animal;

public class Dog extends Animal{

	public Dog()
	{
		this(2);
		System.out.println("a baby birthed");
		
	}
	
	public Dog(int x)
	{
		System.out.println("hello,I am"+x+"dog");
	}
	public void run()
	{
		System.out.println("Dog run");
		set();
	}
	
}
