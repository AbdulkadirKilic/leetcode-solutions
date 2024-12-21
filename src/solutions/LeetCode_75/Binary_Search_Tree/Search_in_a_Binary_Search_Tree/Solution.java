// LeetCode Question: https://leetcode.com/problems/search-in-a-binary-search-tree

package solutions.LeetCode_75.Binary_Search_Tree.Search_in_a_Binary_Search_Tree;

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root; // Return the node if found or null if not present
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}

