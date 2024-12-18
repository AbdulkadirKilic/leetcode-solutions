// LeetCode Question: https://leetcode.com/problems/decode-string

package solutions.LeetCode_75.Decode_String;

import java.util.Stack;

class Solution {
  public String decodeString(String s) {
    Stack<Integer> countStack = new Stack<>();
    Stack<StringBuilder> resultStack = new Stack<>();
    StringBuilder current = new StringBuilder();
    int k = 0;

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        k = k * 10 + (c - '0'); // Build the repeat count
      } else if (c == '[') {
        countStack.push(k);
        resultStack.push(current);
        current = new StringBuilder();
        k = 0;
      } else if (c == ']') {
        int repeatTimes = countStack.pop();
        StringBuilder temp = current;
        current = resultStack.pop();
        while (repeatTimes-- > 0) {
          current.append(temp);
        }
      } else {
        current.append(c); // Append regular characters
      }
    }

    return current.toString();
  }
}
