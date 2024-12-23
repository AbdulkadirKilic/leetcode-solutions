// LeetCode Question: https://leetcode.com/problems/evaluate-division

package solutions.LeetCode_75.Graphs_DFS.Evaluate_Division;

import java.util.*;

class Solution {
  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {
    // Build the graph using adjacency list
    Map<String, Map<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String u = equations.get(i).get(0);
      String v = equations.get(i).get(1);
      double value = values[i];
      graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, value);
      graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / value);
    }

    // Result array for the queries
    double[] results = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String start = queries.get(i).get(0);
      String end = queries.get(i).get(1);
      if (!graph.containsKey(start) || !graph.containsKey(end)) {
        results[i] = -1.0; // Node not found
      } else {
        results[i] = dfs(graph, start, end, new HashSet<>(), 1.0);
      }
    }
    return results;
  }

  private double dfs(
      Map<String, Map<String, Double>> graph,
      String current,
      String target,
      Set<String> visited,
      double value) {
    if (current.equals(target)) {
      return value; // Found the target
    }

    visited.add(current);

    for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
      if (!visited.contains(neighbor.getKey())) {
        double result = dfs(graph, neighbor.getKey(), target, visited, value * neighbor.getValue());
        if (result != -1.0) {
          return result; // Valid path found
        }
      }
    }

    return -1.0; // No valid path found
  }
}
