// LeetCode Question: https://leetcode.com/problems/counting-bits

package solutions.LeetCode_75.Bit_Manipulation.Counting_Bits;

class Solution {
  public int[] countBits(int n) {
    int[] result = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      // Using previously computed results to calculate the number of 1s
      result[i] = result[i >> 1] + (i & 1);
    }

    return result;
  }
}
