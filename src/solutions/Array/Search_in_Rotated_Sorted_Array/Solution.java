// LeetCode Question: https://leetcode.com/problems/search-in-rotated-sorted-array

package solutions.Array.Search_in_Rotated_Sorted_Array;

class Solution {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      // Check if the mid element is the target
      if (nums[mid] == target) {
        return mid;
      }

      // Determine which side is sorted
      if (nums[left] <= nums[mid]) { // Left side is sorted
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1; // Target lies in the left side
        } else {
          left = mid + 1; // Target lies in the right side
        }
      } else { // Right side is sorted
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1; // Target lies in the right side
        } else {
          right = mid - 1; // Target lies in the left side
        }
      }
    }

    return -1; // Target not found
  }
}
