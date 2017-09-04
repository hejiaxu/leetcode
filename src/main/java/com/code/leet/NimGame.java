/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Aug 26, 2016
 * 
 */
public class NimGame {

	public static void main(String[] args) {
		// TODO 
		
	}
	//0ms
	public boolean canWinNim(int n) {
        return n%4!=0;
    }
	
	//0ms
	public boolean canWinNim2(int n) {
		return (3&n)!=0;
	}
}
