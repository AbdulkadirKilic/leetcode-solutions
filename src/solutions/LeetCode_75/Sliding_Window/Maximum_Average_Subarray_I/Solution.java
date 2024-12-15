// LeetCode Question: https://leetcode.com/problems/maximum-average-subarray-i

package solutions.LeetCode_75.Sliding_Window.Maximum_Average_Subarray_I;

class Solution {
  public double findMaxAverage(int[] nums, int k) {
    double maxSum = 0, currentSum = 0;

    for (int i = 0; i < k; i++) {
      currentSum += nums[i];
    }
    maxSum = currentSum;

    for (int i = k; i < nums.length; i++) {
      currentSum += nums[i] - nums[i - k];
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum / k;
  }
}
