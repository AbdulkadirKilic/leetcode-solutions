// LeetCode Question: https://leetcode.com/problems/leaf-similar-trees

package solutions.LeetCode_75.Binary_Tree_DFS.Leaf_Similar_Trees;

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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Collect leaf nodes from both trees
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        // Compare the two leaf node sequences
        return leaves1.equals(leaves2);
    }

    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return; // Base case: null node, do nothing
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val); // Add leaf node value to the list
        } else {
            // Recur for left and right children
            collectLeaves(node.left, leaves);
            collectLeaves(node.right, leaves);
        }
    }
}

