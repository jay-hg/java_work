package com.study.animal;

public class InterfaceStudy {

	public static void main(String[] args) {
		Singer s = new Teacher("xiao ying",26);
		s.sing();
		
		Painter p = (Painter)s;
		p.paint();
	}

}

interface Singer{
	void sing();
	void dance();
}

interface Painter{
	void paint();
	void sleep();
}

class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name=name;
		this.age=age;
	}
}
class Teacher extends Person implements Singer,Painter{
	Teacher(String name, int age){
		super(name,age);
	}
	
	public void sing(){
		System.out.println("Teacher "+name+" sing!");
	}
	
	public void dance(){
		System.out.println("hello,I am Teacher "+name+"I can dance!");
	}
	
	public void paint(){
		System.out.println("A good teacher shuold paint well!");
	}
	
	public void sleep(){
		System.out.println("I am so tired!I need to have a rest!");
	}
}