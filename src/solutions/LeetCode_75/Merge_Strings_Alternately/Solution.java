// LeetCode Question: https://leetcode.com/problems/merge-strings-alternately

package solutions.LeetCode_75.Merge_Strings_Alternately;

class Solution {
  public String mergeAlternately(String word1, String word2) {
    StringBuilder mergedString = new StringBuilder();

    int length1 = word1.length();
    int length2 = word2.length();

    int i = 0;
    while (i < length1 && i < length2) {
      mergedString.append(word1.charAt(i)); // Append character from word1
      mergedString.append(word2.charAt(i)); // Append character from word2
      i++;
    }

    if (i < length1) {
      mergedString.append(word1.substring(i));
    } else if (i < length2) {
      mergedString.append(word2.substring(i));
    }

    return mergedString.toString();
  }
}
