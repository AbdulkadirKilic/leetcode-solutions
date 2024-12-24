// LeetCode Question: https://leetcode.com/problems/rotting-oranges

package solutions.LeetCode_75.Binary_Tree_BFS.Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int orangesRotting(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    int freshCount = 0;

    // Initialize the queue with all rotten oranges and count fresh oranges
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 2) {
          queue.offer(new int[] {r, c}); // Add rotten orange to the queue
        } else if (grid[r][c] == 1) {
          freshCount++; // Count fresh oranges
        }
      }
    }

    // If no fresh oranges, return 0
    if (freshCount == 0) return 0;

    int minutes = 0;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Perform BFS
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean rottenNewOranges = false;

      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        int r = current[0];
        int c = current[1];

        for (int[] dir : directions) {
          int newRow = r + dir[0];
          int newCol = c + dir[1];

          // If the adjacent orange is fresh, make it rotten
          if (newRow >= 0
              && newRow < rows
              && newCol >= 0
              && newCol < cols
              && grid[newRow][newCol] == 1) {
            grid[newRow][newCol] = 2;
            queue.offer(new int[] {newRow, newCol});
            freshCount--;
            rottenNewOranges = true;
          }
        }
      }

      // Only increment minutes if at least one orange rotted in this round
      if (rottenNewOranges) {
        minutes++;
      }
    }

    // If there are still fresh oranges left, return -1
    return freshCount == 0 ? minutes : -1;
  }
}
