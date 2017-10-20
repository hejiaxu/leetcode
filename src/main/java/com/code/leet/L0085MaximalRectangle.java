package com.code.leet;

import java.util.Stack;

/*
Given a 2D binary matrix filled with 0's and 1's,
find the largest rectangle containing only 1's and return its area.


 */
public class L0085MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int height = matrix.length;
        if (height == 0) {
            return max;
        }
        int length = matrix[0].length;
        int[] heights = new int[length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            int val = largestRectangleArea(heights);
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack <>();
        int i = 0;
        while(i < heights.length || !stack.empty()) {
            if (!stack.empty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                Integer pop = stack.pop();
                int value = 0;
                if (stack.empty()) {
                    value = i * heights[pop];
                } else {
                    value = (i - stack.peek() - 1) * heights[pop];
                }
                max = value > max ? value : max;
            } else {
                stack.push(i);
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int i = new L0085MaximalRectangle().maximalRectangle(matrix);
        System.out.println(i);
    }

}
