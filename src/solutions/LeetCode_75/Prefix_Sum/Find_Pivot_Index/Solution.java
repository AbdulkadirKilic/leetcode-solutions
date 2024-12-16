// LeetCode Question: https://leetcode.com/problems/find-pivot-index

package solutions.LeetCode_75.Prefix_Sum.Find_Pivot_Index;

class Solution {
  public int pivotIndex(int[] nums) {
    int totalSum = 0, leftSum = 0;

    for (int num : nums) {
      totalSum += num;
    }

    for (int i = 0; i < nums.length; i++) {
      if (leftSum == totalSum - leftSum - nums[i]) {
        return i;
      }
      leftSum += nums[i];
    }

    return -1;
  }
}
