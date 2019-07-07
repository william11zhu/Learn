package com.learn.design;

public class Singleton {

	public static void main(String[] args) {
		
	}

}

/**
 * 懒汉模式：适合单线程
 * 支持懒加载
 * @author EX_WLJR_ZHUJIEJIAO
 * 
 */
class Singleton1 {
	private static Singleton1 instance = null;

	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		// 多线程时，同时执行到此处，并创建多个实例
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}

/**
 * 懒汉模式：单例模式，因为加锁，效率比较低
 * 支持懒加载
 * @author EX_WLJR_ZHUJIEJIAO
 *
 */
class Singleton2 {
	private static Singleton2 instance = null;

	private Singleton2() {
	}

	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}

/**
 * 双检锁/双重校验锁
 * 懒加载
 * @author EX_WLJR_ZHUJIEJIAO
 *
 */
class Singleton3{
	private static Singleton3 instance = null;
	private Singleton3(){}
	public static Singleton3 getInstance(){
		if(instance == null){
			synchronized(Singleton3.class){
				if(instance == null){
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}

/**
 * 饿汉模式
 * 利用静态构造函数
 * 不支持懒加载
 * @author EX_WLJR_ZHUJIEJIAO
 *
 */
class Singleton4{
	private static Singleton4 instance = new Singleton4();
	private Singleton4(){}
	public static Singleton4 getInstance(){
		return instance;
	}
}

/**
 * 登记式/静态内部类
 * 支持懒加载
 * @author EX_WLJR_ZHUJIEJIAO
 *
 */
class Singleton5{
	private Singleton5(){}
	private static class Instance{
		private static final Singleton5 INSTANCE = new Singleton5();
	}
	public static Singleton5 getInstance(){
		return Instance.INSTANCE;
	}
}

enum Singleton6{
	INSTANCE;
	public void whateverMethod(){}
}


interface Food
{
    enum Coffee implements Food 
    {
        BLACK_COFFEE, DECAF_COFFEE,LATTE;
    }
 
    enum Dessert implements Food
    {
        FRUIT,CAKE,GELATO;
    }
}

