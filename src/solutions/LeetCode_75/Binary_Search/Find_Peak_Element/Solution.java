// LeetCode Question: https://leetcode.com/problems/find-peak-element

package solutions.LeetCode_75.Binary_Search.Find_Peak_Element;

class Solution {
  public int findPeakElement(int[] nums) {
    int low = 0, high = nums.length - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      // Compare mid with the next element
      if (nums[mid] > nums[mid + 1]) {
        // If the current element is greater, the peak is on the left
        high = mid;
      } else {
        // If the next element is greater, the peak is on the right
        low = mid + 1;
      }
    }

    return low; // At the end, low and high converge to the peak index
  }
}
