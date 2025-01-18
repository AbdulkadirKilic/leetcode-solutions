// LeetCode Question: https://leetcode.com/problems/remove-element

package solutions.Array.Remove_Element;

class Solution {
  public int removeElement(int[] nums, int val) {
    int index = 0; // Index for placing non-val elements

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[index] = nums[i];
        index++;
      }
    }

    return index; // The number of elements that are not equal to val
  }
}
