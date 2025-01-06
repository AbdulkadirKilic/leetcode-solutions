// LeetCode Question: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c

package solutions.LeetCode_75.Bit_Manipulation.Minimum_Flips_to_Make_a_OR_b_Equal_to_c;

class Solution {
  public int minFlips(int a, int b, int c) {
    int flips = 0;

    while (a > 0 || b > 0 || c > 0) {
      // Extract the least significant bits of a, b, and c
      int bitA = a & 1;
      int bitB = b & 1;
      int bitC = c & 1;

      // Check conditions for flips
      if (bitC == 0) {
        flips += bitA + bitB; // Both a and b bits must be 0
      } else {
        if (bitA == 0 && bitB == 0) {
          flips++; // At least one of a or b must be 1
        }
      }

      // Shift right to process the next bits
      a >>= 1;
      b >>= 1;
      c >>= 1;
    }

    return flips;
  }
}
