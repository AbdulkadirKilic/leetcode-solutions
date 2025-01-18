// LeetCode Question:
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

package solutions.Array.Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    // Find the leftmost index of the target
    int left = binarySearch(nums, target, true);
    if (left == nums.length || nums[left] != target) {
      return result; // Target not found
    }
    // Find the rightmost index of the target
    int right = binarySearch(nums, target, false) - 1;
    result[0] = left;
    result[1] = right;
    return result;
  }

  private int binarySearch(int[] nums, int target, boolean findFirst) {
    int low = 0, high = nums.length;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > target || (findFirst && nums[mid] == target)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
