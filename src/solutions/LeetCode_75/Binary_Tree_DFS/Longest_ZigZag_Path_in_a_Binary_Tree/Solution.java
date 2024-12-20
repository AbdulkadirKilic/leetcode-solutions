// LeetCode Question: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

package solutions.LeetCode_75.Binary_Tree_DFS.Longest_ZigZag_Path_in_a_Binary_Tree;

class Solution {
    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);  // Start with left direction
        dfs(root, false, 0); // Start with right direction
        return maxZigZag;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return; // Base case: null node
        }

        // Update the maximum ZigZag length
        maxZigZag = Math.max(maxZigZag, length);

        if (isLeft) {
            dfs(node.left, false, length + 1); // Continue ZigZag to the left
            dfs(node.right, true, 1);         // Start new ZigZag to the right
        } else {
            dfs(node.right, true, length + 1); // Continue ZigZag to the right
            dfs(node.left, false, 1);         // Start new ZigZag to the left
        }
    }
}

