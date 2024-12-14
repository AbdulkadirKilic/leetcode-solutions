// LeetCode Question: https://leetcode.com/problems/reverse-words-in-a-string

package solutions.LeetCode_75.Reverse_Words_in_a_String;

class Solution {
  public String reverseWords(String s) {
    // Trim leading and trailing spaces, and split by spaces
    String[] words = s.trim().split("\\s+");

    // Reverse the words array
    StringBuilder result = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      result.append(words[i]);
      if (i != 0) {
        result.append(" "); // Add a space between words
      }
    }

    return result.toString();
  }
}
