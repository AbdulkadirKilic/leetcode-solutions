// LeetCode Question: https://leetcode.com/problems/greatest-common-divisor-of-strings

package solutions.LeetCode_75.Greatest_Common_Divisor_of_Strings;

class Solution {
  public String gcdOfStrings(String str1, String str2) {
    // If the concatenation of the strings in both orders is not equal, no common divisor exists
    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }

    // Calculate the GCD of the lengths and return the substring of that length
    int gcdLength = gcd(str1.length(), str2.length());
    return str1.substring(0, gcdLength);
  }

  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
