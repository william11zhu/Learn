package com.learn;

import org.junit.Test;

import com.learning.Father;
import com.learning.Son;

public class TestInit {
	
	
	@Test
	public void TestConstructorInit() {
		Son son = new Son();
		son.defaultMethod("HAHAHA");
		Father father = new Father();
		son.saySomething("cao ni da ye ");
	}
	
	
	
}
