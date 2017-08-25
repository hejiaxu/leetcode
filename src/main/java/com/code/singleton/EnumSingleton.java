/**
 * 
 */
package com.designPattern.singleton;

/**
 * @author Jiaxu
 * @date Jul 28, 2016
 * @description
 * @version 1.0
 */

public enum EnumSingleton{
	INSTANCE;
	private SingletonInstance singleton;
	EnumSingleton() {
		singleton = new SingletonInstance();
	}
	public SingletonInstance getInstance(){
		
		return singleton;
	}
	private class SingletonInstance{
	}
	
	public static void main(String[] args) {
		SingletonInstance instance2 = EnumSingleton.INSTANCE.getInstance();
		
	}
}