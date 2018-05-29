package com.learning;

public class Son extends Father {
	
	public Son() {
		System.out.println("init Son");
		super.defaultMethod("Son");
	}

	@Override
	public void sing(String songName) {
		super.sing(songName);
		System.out.println("Son sing a song named "+songName);
		
	}
	
	@Override
	public void saySomething(String words) {
		super.saySomething(words);
		System.out.println("Son say something: "+words);
	}
}
