package com.learning;

public abstract class ExtendsBase implements Base {
	
	
	public ExtendsBase() {
		System.out.println("init ExtendsBase");
		saySomething("ExtendsBase");
		this.defaultMethod("....");
		
	}

	@Override
	public void saySomething(String words) {
		System.out.println("ExtendsBase say "+words);
	}
	
	public abstract void sing(String songName);
	
}
