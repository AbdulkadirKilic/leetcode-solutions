// LeetCode Question:
// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

package solutions.LeetCode_75.Sliding_Window.Longest_Subarray_of_1s_After_Deleting_One_Element;

class Solution {
  public int longestSubarray(int[] nums) {
    int left = 0, maxLen = 0, zeroCount = 0;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        zeroCount++;
      }

      while (zeroCount > 1) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }

      maxLen = Math.max(maxLen, right - left);
    }

    return maxLen;
  }
}
