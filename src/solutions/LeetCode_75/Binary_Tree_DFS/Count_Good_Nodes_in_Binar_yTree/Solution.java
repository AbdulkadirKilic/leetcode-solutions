// LeetCode Question: https://leetcode.com/problems/count-good-nodes-in-binary-tree

package solutions.LeetCode_75.Binary_Tree_DFS.Count_Good_Nodes_in_Binar_yTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0; // Base case: null node
        }

        int goodNodeCount = 0;
        if (node.val >= maxSoFar) {
            goodNodeCount = 1; // Current node is a good node
        }

        // Update the maximum value seen so far
        int newMax = Math.max(maxSoFar, node.val);

        // Recur for left and right children
        goodNodeCount += countGoodNodes(node.left, newMax);
        goodNodeCount += countGoodNodes(node.right, newMax);

        return goodNodeCount;
    }
}

