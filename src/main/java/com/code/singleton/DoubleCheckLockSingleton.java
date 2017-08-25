/**
 * 
 */
package com.designPattern.singleton;
public class DoubleCheckLockSingleton {
	private static DoubleCheckLockSingleton singleton = null;
	
	private DoubleCheckLockSingleton(){
		
	}
	
	public static DoubleCheckLockSingleton getInstance(){
		if (null == singleton) {
			synchronized (DoubleCheckLockSingleton.class) {
				if (null == singleton) {
					singleton = new DoubleCheckLockSingleton();
				}
			}
		}
		return singleton;
	}
	public static void main(String[] args) {
		DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
		
	}
}