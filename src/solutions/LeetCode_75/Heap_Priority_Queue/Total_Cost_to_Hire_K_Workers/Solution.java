// LeetCode Question: https://leetcode.com/problems/total-cost-to-hire-k-workers

package solutions.LeetCode_75.Heap_Priority_Queue.Total_Cost_to_Hire_K_Workers;

import java.util.PriorityQueue;

class Solution {
  public long totalCost(int[] costs, int k, int candidates) {
    PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    int left = 0, right = costs.length - 1;
    long totalCost = 0;

    // Add the first `candidates` workers to the left heap and the last `candidates` workers to the
    // right heap
    for (int i = 0; i < candidates && left <= right; i++) {
      leftHeap.add(costs[left++]);
      if (left <= right) {
        rightHeap.add(costs[right--]);
      }
    }

    for (int i = 0; i < k; i++) {
      // Determine the minimum cost worker to hire
      if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
        totalCost += leftHeap.poll(); // Hire from left
        if (left <= right) {
          leftHeap.add(costs[left++]); // Add next worker from the left
        }
      } else {
        totalCost += rightHeap.poll(); // Hire from right
        if (left <= right) {
          rightHeap.add(costs[right--]); // Add next worker from the right
        }
      }
    }

    return totalCost;
  }
}
