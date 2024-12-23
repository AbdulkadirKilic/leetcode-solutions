// LeetCode Question:
// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

package solutions.LeetCode_75.Graphs_DFS.Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.*;

class Solution {
  public int minReorder(int n, int[][] connections) {
    // Create an adjacency list to store both original and reversed edges
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] conn : connections) {
      graph
          .computeIfAbsent(conn[0], k -> new ArrayList<>())
          .add(new int[] {conn[1], 1}); // Original direction
      graph
          .computeIfAbsent(conn[1], k -> new ArrayList<>())
          .add(new int[] {conn[0], 0}); // Reversed direction
    }

    // BFS traversal to count changes needed
    int changes = 0;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int[] neighbor : graph.getOrDefault(current, new ArrayList<>())) {
        if (!visited[neighbor[0]]) {
          visited[neighbor[0]] = true;
          changes += neighbor[1]; // Add to changes if it was an original edge
          queue.add(neighbor[0]);
        }
      }
    }

    return changes;
  }
}
