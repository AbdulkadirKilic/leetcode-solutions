// LeetCode Question: https://leetcode.com/problems/kth-largest-element-in-an-array

package solutions.LeetCode_75.Heap_Priority_Queue.Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    // Min-heap to store the k largest elements
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Iterate through the array
    for (int num : nums) {
      // Add the current number to the heap
      minHeap.offer(num);

      // Ensure the heap size does not exceed k
      if (minHeap.size() > k) {
        minHeap.poll(); // Remove the smallest element
      }
    }

    // The root of the heap is the kth largest element
    return minHeap.peek();
  }
}
