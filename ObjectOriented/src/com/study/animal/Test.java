package com.study.animal;

public class Test {

	public static void main(String[] args) {
		Animal a = new Dog("Big yellow",3);
		Gril gril = new Gril("ML");
		gril.myPet(a);
		gril.somethingOfPet();
		
		gril.myPet(new Cat("Small black",2));
		gril.somethingOfPet();
		
		
	}

}

abstract class Animal{
	int age;
	String name;
	
	Animal (String name, int age){
		this.age = age;
		this.name =  name;
	}
	
	public abstract void enjoy();
	
	public abstract void run();
	
	public abstract void mySkills();
}

class Dog extends Animal{
	
	Dog (String name, int age){
		super(name,age);
	}
	@Override
	public void enjoy(){
		System.out.println("A "+age+"year-old dog,"+name+",cry...bao wang...");
	}
	
	@Override
	public void run(){
		System.out.println(name+" run fast!");
	}
	
	@Override
	public void mySkills(){
		enjoy();
		run();
	}
}

class Cat extends Animal{
	
	Cat (String name, int age){
		super(name,age);
	}
	
	public void catchMouse(){
		System.out.println(name+" can catch so many mouses!!!");
	}
	
	@Override
	public void enjoy(){
		System.out.println("A "+age+"year-old cat,"+name+",cry...miao miao...");
	}
	
	@Override
	public void run(){
		System.out.println(name+" run!run!run!");
	}
	
	@Override
	public void mySkills(){
		enjoy();
		run();
		catchMouse();
	}
}

class Gril{
	Animal pet;
	String name;
	
	Gril(String name){
		this.name = name;
	}
	
	public void myPet(Animal pet){
		this.pet = pet;
	}
	
	public void somethingOfPet(){
		pet.mySkills();
	}
}