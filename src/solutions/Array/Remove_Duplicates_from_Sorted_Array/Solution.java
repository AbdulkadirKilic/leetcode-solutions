// LeetCode Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array

package solutions.Array.Remove_Duplicates_from_Sorted_Array;

class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int uniqueIndex = 0; // Pointer to place the next unique number

    for (int i = 1; i < nums.length; i++) {
      // Check if the current number is different from the last unique number
      if (nums[i] != nums[uniqueIndex]) {
        uniqueIndex++; // Move the unique index forward
        nums[uniqueIndex] = nums[i]; // Place the unique number at the new position
      }
    }

    return uniqueIndex + 1; // The number of unique elements
  }
}
