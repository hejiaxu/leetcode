/**
 * 
 */
package com.algorithm.leetcode;

/**
 * Jiaxu
 * Jun 27, 2017
 * 
 */
public class UniquePathsII {

	public static void main(String[] args) {
		// TODO 
//		int[][] obstacleGrid = {{0,0}};
		int[][] obstacleGrid = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int uniquePathsWithObstacles = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(uniquePathsWithObstacles);
		
	}
	
	
	//1ms
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0||obstacleGrid[0][0]==1) {
			return 0;
		}
    	int m=obstacleGrid.length;
    	int n=obstacleGrid[0].length;
    	int[] tmp = new int[m];
    	tmp[0]=1;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			if(j==0){
    				if (tmp[j]!=0&&obstacleGrid[j][i]!=1)tmp[j]=1;
    				else tmp[j]=0;
    			}else if (obstacleGrid[j][i]==1) {
    		    	tmp[j]=0;
				}else {
					tmp[j]+=tmp[j-1];
				}
    		}
		}
    	return tmp[m-1];
    }
}
