package com.example;

public class SunObject extends FatherObject {
	public int age = 30;
	public String name = "meifei";
	private Integer score = 30;
	
	public void printName(){
		System.out.println(name);
	}
	
	
	
	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getScore() {
		return score;
	}



	public void setScore(Integer score) {
		this.score = score;
	}

	public SunObject(){}
	
	public SunObject(String name){}
	
	public SunObject(int age, Integer score){}
	

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		super.doSomething();
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run ...");
	}
	
	
	private void private_call(){
		
	}
	

}
