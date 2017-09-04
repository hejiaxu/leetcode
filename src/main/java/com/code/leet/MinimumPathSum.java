/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 27, 2017
 * 
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO 
		int[][] obstacleGrid = {{1,3,1},{1,5,1},{4,2,1}};
		int uniquePathsWithObstacles = minPathSum(obstacleGrid);
		System.out.println(uniquePathsWithObstacles);
	}
	
	
	//4ms
    public static int minPathSum(int[][] grid) {
        if (grid==null||grid.length==0) {
			return 0;
		}
        int n = grid.length,m=grid[0].length;
        int[] tmp = new int[m];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j==0){
					tmp[j]+=grid[i][j];
				}else if (i==0) {
					tmp[j]=grid[i][j]+tmp[j-1];
				}else{
					tmp[j]=Math.min(tmp[j-1], tmp[j])+grid[i][j];
				}
			}
		}
        return tmp[m-1];
    }

}
