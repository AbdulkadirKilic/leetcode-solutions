// LeetCode Question: https://leetcode.com/problems/keys-and-rooms

package solutions.LeetCode_75.Graphs_DFS.Keys_and_Rooms;

import java.util.List;

class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    dfs(rooms, 0, visited); // Start DFS from room 0

    for (boolean roomVisited : visited) {
      if (!roomVisited) return false; // Return false if any room is unvisited
    }
    return true;
  }

  private void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visited) {
    visited[currentRoom] = true; // Mark the current room as visited
    for (int key : rooms.get(currentRoom)) {
      if (!visited[key]) {
        dfs(rooms, key, visited); // Visit the room corresponding to the key
      }
    }
  }
}
