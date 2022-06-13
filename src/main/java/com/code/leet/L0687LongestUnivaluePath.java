package com.code.leet;
/*
Given a binary tree, find the length of the longest path where each node in the path has the same value.
This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class L0687LongestUnivaluePath {

    public static void main(String[] args) {

    }

    int maxG = 1;
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return maxG - 1;
    }

    private int dfs(TreeNode root) {
        int singleEdgeMax = 1;
        int left = 0;
        int twoEdgeMax = 1;
        if (root.left != null) {
            int dfs = dfs(root.left);
            if (root.val == root.left.val) {
                left = dfs;
                twoEdgeMax += dfs;
            }
        }
        int right = 0;
        if (root.right != null) {
            int dfs = dfs(root.right);
            if (root.val == root.right.val) {
                right = dfs;
                twoEdgeMax += dfs;

            }
        }

        singleEdgeMax += left > right ? left : right;
        if (twoEdgeMax > maxG) {
            maxG = twoEdgeMax;
        }
        return singleEdgeMax;
    }


    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
