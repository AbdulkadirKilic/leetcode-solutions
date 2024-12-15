// LeetCode Question: https://leetcode.com/problems/is-subsequence

package solutions.LeetCode_75.Is_Subsequence;

class Solution {
  public boolean isSubsequence(String s, String t) {
    int sIndex = 0, tIndex = 0;

    // Traverse both strings to check if 's' is a subsequence of 't'
    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
      }
      tIndex++;
    }

    return sIndex == s.length();
  }
}
