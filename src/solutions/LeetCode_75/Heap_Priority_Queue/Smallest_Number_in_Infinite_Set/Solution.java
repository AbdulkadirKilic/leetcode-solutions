// LeetCode Question: https://leetcode.com/problems/smallest-number-in-infinite-set

package solutions.LeetCode_75.Heap_Priority_Queue.Smallest_Number_in_Infinite_Set;

import java.util.TreeSet;

class SmallestInfiniteSet {
  private TreeSet<Integer> set;

  public SmallestInfiniteSet() {
    set = new TreeSet<>();
    for (int i = 1; i <= 1000; i++) {
      set.add(i); // Initialize with all positive integers starting from 1
    }
  }

  public int popSmallest() {
    return set.pollFirst(); // Remove and return the smallest number
  }

  public void addBack(int num) {
    set.add(num); // Add the number back if not already present
  }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such: SmallestInfiniteSet obj
 * = new SmallestInfiniteSet(); int param_1 = obj.popSmallest(); obj.addBack(num);
 */
