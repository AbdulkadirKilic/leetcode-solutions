// LeetCode Question: https://leetcode.com/problems/number-of-provinces

package solutions.LeetCode_75.Graphs_DFS.Number_of_Provinces;

class Solution {
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    boolean[] visited = new boolean[n];
    int provinces = 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(isConnected, visited, i); // Start a DFS for a new province
        provinces++; // Increment province count
      }
    }

    return provinces;
  }

  private void dfs(int[][] isConnected, boolean[] visited, int city) {
    visited[city] = true;
    for (int j = 0; j < isConnected.length; j++) {
      if (isConnected[city][j] == 1 && !visited[j]) {
        dfs(isConnected, visited, j); // Recursively visit connected cities
      }
    }
  }
}
