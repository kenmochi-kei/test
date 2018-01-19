package jp.co.internous.action;

public class Person {

	public String name = null;
	public int age = 0;

	public Person(){}
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	public Person(String name){
		this.name = name;
	}
	public Person(int age){
		this.age = age;
	}
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}

}
