/**
 * 
 */
package com.designPattern.simpleFactory;

/**
 * Jiaxu
 * Mar 9, 2017
 * 
 */
public class Client {

	public static void main(String[] args) {
		// TODO 
		FruitFactory factory = new FruitFactory();
		Fruit produce = factory.produce("apple");
		produce.print();
	}

}
