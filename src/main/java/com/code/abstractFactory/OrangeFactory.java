/**
 * 
 */
package com.designPattern.abstractFactory;

/**
 * Jiaxu
 * Mar 9, 2017
 * 
 */
public class OrangeFactory implements FruitFactory {
	public Fruit produce(){
		return new Orange();
	}
	public FruitBad produceBad(){
		return new OrangeBad();
	}
	
}