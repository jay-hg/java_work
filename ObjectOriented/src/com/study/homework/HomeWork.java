package com.study.homework;

public class HomeWork {

	public static void main(String[] args) {
		Worker w = new Worker(new Dog("da hei"));
		w.feed();
		w.enjoy();
		
		Famer f = new Famer(new Dog("xiao hei"));
		f.feed();
		f.enjoy();
		
		DogGuan d = new DogGuan(new Dog("xiao bai"));
		d.feed();
		d.enjoy();
	}

}

interface PetCare{
	public void feed();
	public void enjoy();
}

class Person{
	Animal pet;
	
	Person(Animal pet){
		this.pet=pet;
	}
}

abstract class Animal{
	String name;
	
	Animal(String name){
		this.name=name;
	}
	
	public abstract void enjoy();
}

class Dog extends Animal{
	Dog(String name){
		super(name);
	}
	public void enjoy(){
		System.out.println("dog is so happpy!");
	}
}

class Worker extends Person implements PetCare{
	
	Worker(Animal pet){
		super(pet);
	}
	
	public void feed(){
		System.out.println("my "+pet.name+" feed on bone");
	}
	
	public void enjoy(){
		System.out.println("my pet play tools");
	}
}

class Famer extends Person implements PetCare{
	
	Famer(Animal pet){
		super(pet);
	}
	
	public void feed(){
		System.out.println("my "+pet.name+" feed on vegetable");
	}
	
	public void enjoy(){
		System.out.println("my pet play mouse!");
	}
}

class DogGuan extends Person implements PetCare{
	
	DogGuan(Animal pet){
		super(pet);
	}
	
	public void feed(){
		System.out.println("my "+pet.name+" feed on meat");
	}
	
	public void enjoy(){
		System.out.println("my pet play toys");
	}
}