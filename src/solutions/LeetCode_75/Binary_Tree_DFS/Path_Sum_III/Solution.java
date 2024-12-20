// LeetCode Question: https://leetcode.com/problems/path-sum-iii

package solutions.LeetCode_75.Binary_Tree_DFS.Path_Sum_III;

import java.util.HashMap;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1); // Base case: empty path with sum 0
        return dfs(root, 0, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSum) {
        if (node == null) {
            return 0;
        }

        // Update the current sum
        currentSum += node.val;

        // Calculate the number of paths that end at this node and sum to targetSum
        int paths = prefixSum.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum map
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        // Recur for left and right children
        paths += dfs(node.left, currentSum, targetSum, prefixSum);
        paths += dfs(node.right, currentSum, targetSum, prefixSum);

        // Backtrack: remove the current sum from the map
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);

        return paths;
    }
}

