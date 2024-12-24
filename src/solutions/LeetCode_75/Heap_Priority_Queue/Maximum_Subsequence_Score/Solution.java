// LeetCode Question: https://leetcode.com/problems/maximum-subsequence-score

package solutions.LeetCode_75.Heap_Priority_Queue.Maximum_Subsequence_Score;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
  public long maxScore(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int[][] pairs = new int[n][2];

    // Create pairs of nums1 and nums2 and sort them by nums2 in descending order
    for (int i = 0; i < n; i++) {
      pairs[i][0] = nums1[i];
      pairs[i][1] = nums2[i];
    }
    Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

    // Min-heap to maintain the top k elements of nums1
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    long sum = 0, maxScore = 0;

    // Iterate through pairs and calculate the maximum score
    for (int i = 0; i < n; i++) {
      sum += pairs[i][0];
      minHeap.offer(pairs[i][0]);

      // Maintain only the top k elements in the heap
      if (minHeap.size() > k) {
        sum -= minHeap.poll();
      }

      // Calculate the score only if we have exactly k elements
      if (minHeap.size() == k) {
        maxScore = Math.max(maxScore, sum * pairs[i][1]);
      }
    }

    return maxScore;
  }
}
