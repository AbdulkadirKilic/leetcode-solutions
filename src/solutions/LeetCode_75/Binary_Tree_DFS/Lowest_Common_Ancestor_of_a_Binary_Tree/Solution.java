// LeetCode Question: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

package solutions.LeetCode_75.Binary_Tree_DFS.Lowest_Common_Ancestor_of_a_Binary_Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the current node is null, p, or q, return the node
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, the current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If one side is null, return the non-null side
        return left != null ? left : right;
    }
}

