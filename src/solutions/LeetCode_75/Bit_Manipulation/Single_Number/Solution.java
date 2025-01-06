// LeetCode Question: https://leetcode.com/problems/single-number

package solutions.LeetCode_75.Bit_Manipulation.Single_Number;

class Solution {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num; // XOR operation to find the unique number
    }
    return result;
  }
}
