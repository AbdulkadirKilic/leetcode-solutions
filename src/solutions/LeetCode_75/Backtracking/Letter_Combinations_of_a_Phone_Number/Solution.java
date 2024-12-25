// LeetCode Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number

package solutions.LeetCode_75.Backtracking.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result; // Return empty list for invalid input
    }

    // Map of digits to their corresponding letters
    String[] mapping = {
      "", // 0
      "", // 1
      "abc", // 2
      "def", // 3
      "ghi", // 4
      "jkl", // 5
      "mno", // 6
      "pqrs", // 7
      "tuv", // 8
      "wxyz" // 9
    };

    backtrack(result, new StringBuilder(), digits, 0, mapping);
    return result;
  }

  private void backtrack(
      List<String> result, StringBuilder combination, String digits, int index, String[] mapping) {
    if (index == digits.length()) {
      result.add(combination.toString()); // Add complete combination to the result
      return;
    }

    String letters = mapping[digits.charAt(index) - '0']; // Get letters for the current digit
    for (char letter : letters.toCharArray()) {
      combination.append(letter); // Add the letter
      backtrack(
          result,
          combination,
          digits,
          index + 1,
          mapping); // Recursively generate further combinations
      combination.deleteCharAt(combination.length() - 1); // Backtrack to explore other options
    }
  }
}
