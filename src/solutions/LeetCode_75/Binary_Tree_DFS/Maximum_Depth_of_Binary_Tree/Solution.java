// LeetCode Question: https://leetcode.com/problems/maximum-depth-of-binary-tree

package solutions.LeetCode_75.Binary_Tree_DFS.Maximum_Depth_of_Binary_Tree;

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the tree is empty, depth is 0
        }
        // Recursive case: find max depth of left and right subtrees and add 1 for the current node
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

