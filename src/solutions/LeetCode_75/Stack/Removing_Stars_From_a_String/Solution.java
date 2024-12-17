// LeetCode Question: https://leetcode.com/problems/removing-stars-from-a-string

package solutions.LeetCode_75.Stack.Removing_Stars_From_a_String;

class Solution {
  public String removeStars(String s) {
    StringBuilder result = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (c == '*') {
        result.deleteCharAt(result.length() - 1); // Remove last non-star character
      } else {
        result.append(c); // Append current character
      }
    }

    return result.toString();
  }
}
