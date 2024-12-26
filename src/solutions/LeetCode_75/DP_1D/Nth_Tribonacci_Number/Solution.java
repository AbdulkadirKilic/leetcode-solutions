// LeetCode Question: https://leetcode.com/problems/n-th-tribonacci-number

package solutions.LeetCode_75.DP_1D.Nth_Tribonacci_Number;

class Solution {
  public int tribonacci(int n) {
    if (n == 0) return 0; // Base case for T0
    if (n == 1 || n == 2) return 1; // Base cases for T1 and T2

    int t0 = 0, t1 = 1, t2 = 1; // Initial values for T0, T1, T2
    int tn = 0;

    for (int i = 3; i <= n; i++) {
      tn = t0 + t1 + t2; // Calculate the current Tribonacci number
      t0 = t1; // Shift t0 to t1
      t1 = t2; // Shift t1 to t2
      t2 = tn; // Shift t2 to tn
    }

    return tn; // Return the nth Tribonacci number
  }
}
