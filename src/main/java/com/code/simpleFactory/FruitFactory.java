/**
 * 
 */
package com.designPattern.simpleFactory;

/**
 * Jiaxu
 * Mar 9, 2017
 * 
 */
public class FruitFactory {
	public Fruit produce(String fruit){
		if ("apple" == fruit) {
			return new Apple();
		}else if ("orange" == fruit) {
			return new Orange();
		}
		return null;
	}
}
