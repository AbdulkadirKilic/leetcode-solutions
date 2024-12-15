// LeetCode Question: https://leetcode.com/problems/move-zeroes

package solutions.LeetCode_75.Move_Zeroes;

class Solution {
  public void moveZeroes(int[] nums) {
    int index = 0;

    for (int num : nums) {
      if (num != 0) {
        nums[index++] = num;
      }
    }

    while (index < nums.length) {
      nums[index++] = 0;
    }
  }
}
