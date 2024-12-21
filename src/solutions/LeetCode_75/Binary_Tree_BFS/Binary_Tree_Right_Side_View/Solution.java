// LeetCode Question: https://leetcode.com/problems/binary-tree-right-side-view

package solutions.LeetCode_75.Binary_Tree_BFS.Binary_Tree_Right_Side_View;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Return empty list if the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Add the last node of each level to the result
                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                // Add left and right children to the queue
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return result;
    }
}

