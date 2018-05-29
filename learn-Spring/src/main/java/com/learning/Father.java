package com.learning;

public class Father extends ExtendsBase{
	
	public Father() {
		System.out.println("init Father");
		sing("yesterday once more");
	}

	@Override
	public void defaultMethod(String name) {
		super.defaultMethod(name);
		System.out.println("Father");
	}
	
	@Override
	public void sing(String songName) {
		super.defaultMethod(songName);
		System.out.println("Father sing a song named "+songName);
		
	}
	
	@Override
	public void saySomething(String words) {
		super.saySomething(words);
		System.out.println("Father say something: "+words);
	}

}
