/**
 * 
 */
package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Jiaxu
 * Oct 20, 2016
 * 
 */
public class CountBattleships {

	public static void main(String[] args) {
		// TODO 
		CountBattleships bean = new CountBattleships();
		char[][] input = new char[10][5];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = '.';
//				System.out.print(input[i][j]);
			}
//			System.out.println();
		}
		int result = bean.countBattleships(input);
		System.out.println(result);
		
	}
	
	//5ms
	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (
						i==0 && j==0 && board[i][j] == 'X'
						|| i!=0 && j==0 && board[i][j] == 'X' && board[i-1][j]== '.'
						|| i==0 && j!=0 && board[i][j] == 'X' && board[i][j-1]== '.'
						|| i!=0 && j!=0 && board[i][j] == 'X' && board[i-1][j]== '.' && board[i][j-1] == '.'
						) {
					count++;
				}
			}
		}
		return count;
    }
	
	//4ms
	public int countBattleships2(char[][] board) {
	    int count = 0;
	    for(int i=0;i<board.length;i++)
	        for(int j=0;j<board[0].length;j++)
	            if(board[i][j]=='X' && (i==0 || board[i-1][j]!='X') && (j==0 || board[i][j-1]!='X')) count++;
	        return count;
	    }
}
