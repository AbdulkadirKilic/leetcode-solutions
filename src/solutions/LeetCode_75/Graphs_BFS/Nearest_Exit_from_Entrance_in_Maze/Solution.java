// LeetCode Question: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

package solutions.LeetCode_75.Graphs_BFS.Nearest_Exit_from_Entrance_in_Maze;

import java.util.*;

class Solution {
  public int nearestExit(char[][] maze, int[] entrance) {
    int rows = maze.length;
    int cols = maze[0].length;

    // Directions: up, down, left, right
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Queue for BFS
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {entrance[0], entrance[1], 0}); // row, col, distance

    // Mark the entrance as visited
    maze[entrance[0]][entrance[1]] = '+';

    // BFS traversal
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int row = current[0];
      int col = current[1];
      int distance = current[2];

      for (int[] dir : directions) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];

        // Check if new position is within bounds and not a wall
        if (newRow >= 0
            && newRow < rows
            && newCol >= 0
            && newCol < cols
            && maze[newRow][newCol] == '.') {
          // Check if it's an exit
          if (newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1) {
            return distance + 1;
          }
          // Mark as visited and add to queue
          maze[newRow][newCol] = '+';
          queue.offer(new int[] {newRow, newCol, distance + 1});
        }
      }
    }

    // No exit found
    return -1;
  }
}
