// LeetCode Question: https://leetcode.com/problems/string-compression

package solutions.LeetCode_75.String_Compression;

class Solution {
  public int compress(char[] chars) {
    int write = 0, read = 0;

    while (read < chars.length) {
      char currentChar = chars[read];
      int count = 0;

      // Count the number of consecutive repeating characters
      while (read < chars.length && chars[read] == currentChar) {
        read++;
        count++;
      }

      // Write the character
      chars[write++] = currentChar;

      // Write the count if greater than 1
      if (count > 1) {
        for (char c : Integer.toString(count).toCharArray()) {
          chars[write++] = c;
        }
      }
    }

    return write;
  }
}
