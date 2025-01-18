// LeetCode Question: https://leetcode.com/problems/next-permutation

package solutions.Array.Next_Permutation;

class Solution {
  public void nextPermutation(int[] nums) {
    int n = nums.length;
    int i = n - 2;

    // Find the first index `i` such that nums[i] < nums[i + 1]
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    // If such an index is found, find the next larger number to swap with nums[i]
    if (i >= 0) {
      int j = n - 1;
      while (nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }

    // Reverse the numbers after index `i` to get the next permutation
    reverse(nums, i + 1, n - 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }
}
