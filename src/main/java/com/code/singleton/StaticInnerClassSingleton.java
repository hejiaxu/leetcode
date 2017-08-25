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

public class StaticInnerClassSingleton {
	
	private StaticInnerClassSingleton(){
		
	}
	
	private static class Undertow{
		private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();

	}
	public static StaticInnerClassSingleton getInstance(){
		return Undertow.singleton;
	}
	public static void main(String[] args) {
		StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
		
	}
}
