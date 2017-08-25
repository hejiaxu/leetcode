/**
 * 
 */
package com.designPattern.methodFactory;

/**
 * Jiaxu
 * Mar 9, 2017
 * 
 */
public class Client {

	public static void main(String[] args) {
		// TODO 
		FruitFactory factory = new AppleFactory();
		Fruit produce = factory.produce();
		produce.print();
	}

}
