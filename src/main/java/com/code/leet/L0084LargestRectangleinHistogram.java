package com.code.leet;

import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height
where the width of each bar is 1,
find the area of largest rectangle in the histogram.
 */
public class L0084LargestRectangleinHistogram {

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
        int[] heights = {2,1,2};
        int i = new L0084LargestRectangleinHistogram().largestRectangleArea(heights);
        System.out.println(i);
    }
}
