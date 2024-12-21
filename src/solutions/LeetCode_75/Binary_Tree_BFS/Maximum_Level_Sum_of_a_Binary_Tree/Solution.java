// LeetCode Question: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

package solutions.LeetCode_75.Binary_Tree_BFS.Maximum_Level_Sum_of_a_Binary_Tree;

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
import java.util.*;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0; // If the tree is empty, return 0
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE; // Track the maximum sum encountered
        int maxLevel = 0; // Track the level with the maximum sum
        int currentLevel = 1; // Start from level 1

        while (!queue.isEmpty()) {
            int levelSum = 0;
            int levelSize = queue.size(); // Number of nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val; // Add the current node's value to the level sum

                if (currentNode.left != null) {
                    queue.add(currentNode.left); // Add left child to the queue
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right); // Add right child to the queue
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum; // Update maximum sum
                maxLevel = currentLevel; // Update level with maximum sum
            }

            currentLevel++; // Move to the next level
        }

        return maxLevel; // Return the level with the maximum sum
    }
}

